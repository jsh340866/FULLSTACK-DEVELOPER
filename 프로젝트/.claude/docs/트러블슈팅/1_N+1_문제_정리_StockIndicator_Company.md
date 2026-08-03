# 1. N+1 문제 — StockIndicator ↔ Company

## 배경

`StockIndicator`(지표계산)와 `Company`(기업정보)는 `stock_code`를 기준으로 1:1 관계다.

```java
// StockIndicator.java
@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "stock_code", insertable = false, updatable = false)
private Company company;
```

`@OneToOne`의 JPA 기본값은 EAGER(즉시 로딩)지만, `Company`에는 `financialStatements`, `stockPrices`, `dividendInfos` 등 무거운 연관관계가 다수 걸려 있어([Company.java](../../../valuepick/src/main/java/com/example/demo/domain/entity/Company.java)), 기업정보가 필요 없는 조회(예: PER 상위 5개 조회)에서까지 매번 자동으로 딸려오는 낭비를 막기 위해 `LAZY`로 명시적으로 전환했다.

## 즉시 로딩(EAGER) vs 지연 로딩(LAZY)

| | EAGER | LAZY |
|---|---|---|
| 연관 엔티티를 가져오는 시점 | 조회하는 즉시 | 실제로 그 필드(getter)를 사용할 때 |
| 조회 시 연관 필드 자리 | 진짜 데이터로 채워짐 | 프록시(빈 껍데기, PK만 아는 대역 객체)가 채워짐 |
| `@OneToOne` / `@ManyToOne` 기본값 | ⭕ 기본값 | 명시해야 적용 |
| `@OneToMany` / `@ManyToMany` 기본값 | 명시해야 적용 | ⭕ 기본값 |

**프록시**는 GoF Proxy 패턴 중 Virtual Proxy에 해당한다. `null`이 아니라 실재하는 객체이며, 내부에는 연관 엔티티의 PK 값만 미리 채워져 있고 나머지 필드는 비어있다. 프록시의 아무 getter나 최초로 호출되는 순간, 그 PK를 조건으로 `SELECT` 쿼리가 실행되어 해당 로우의 모든 컬럼이 한 번에 채워진다(컬럼별로 프록시가 따로 있는 게 아니라, 연관 엔티티 하나당 프록시 하나다).

## TOP100 계산 로직에서 N+1이 발생하는 지점

TOP100 스코어링은 지표값(PER/PBR/ROE 등, `STOCK_INDICATOR` 소속)뿐 아니라 코스피 여부·업종코드·금융업 여부처럼 **`Company` 테이블에만 있는 자격 조건**도 같이 봐야 한다.

```java
// Top100Service.calculateAndSave() — 만약 JOIN FETCH 없이 findAll()로 가져왔다면
List<StockIndicator> indicators = stockIndicatorRepository.findAll(); // 쿼리 1번

List<StockIndicator> candidates = indicators.stream()
        .filter(i -> "Y".equals(i.getCompany().getCorpCls()))         // 코스피 여부
        .filter(i -> i.getCompany().getIndutyCode() != null)          // 업종코드 존재 여부
        .filter(i -> i.getCompany().isFinancialIndustry()             // 금융업 여부
                || (i.getFScore() != null && i.getFScore() >= F_SCORE_PASS_THRESHOLD))
        .collect(Collectors.toList());
```

상장 종목이 **2,555개**라고 하면:

- `findAll()` 실행 → `SELECT * FROM STOCK_INDICATOR` **1번** (지표 2,555건, `company`는 전부 빈 프록시)
- `.filter()`에서 각 건마다 `i.getCompany().getCorpCls()`를 처음 호출하는 순간, 그 지표의 `company` 프록시가 초기화되며 `SELECT * FROM COMPANY WHERE stock_code = ?` 개별 실행 → **2,555번**
- 총 쿼리 수: **1 + 2,555 = 2,556번** ← 이것이 N+1 문제

### EAGER였어도 결과는 동일하다

EAGER는 "지연시키지 않고 즉시 가져온다"만 보장할 뿐, "한 번의 JOIN으로 가져온다"는 보장은 하지 않는다. 리스트 조회(`findAll()`) 시 EAGER 연관관계는 흔히 각 건마다 개별 SELECT를 즉시 실행하는 방식으로 처리된다.

```java
// 만약 Company가 EAGER였다면
List<StockIndicator> indicators = stockIndicatorRepository.findAll();
// ↑ 이 한 줄이 끝나는 시점에 이미:
//   SELECT * FROM STOCK_INDICATOR                    (1번)
//   SELECT * FROM COMPANY WHERE stock_code = ? × 2555 (조회 즉시 전부 실행됨)
// 즉 메서드 리턴 전에 총 2,556번의 쿼리가 이미 끝나 있다
```

| | EAGER | LAZY |
|---|---|---|
| 쿼리가 터지는 시점 | `findAll()` 호출 그 자리에서 즉시 | 이후 `.stream().filter()`에서 순회하며 `.getCompany()`를 건드릴 때 |
| 총 쿼리 수 | 1 + 2,555 = 2,556 | 1 + 2,555 = 2,556 |

**결론: N+1은 EAGER/LAZY 어느 쪽으로 설정해도 해결되지 않는다.** 차이는 쿼리가 터지는 코드상의 위치일 뿐, 총 쿼리 개수는 동일하다.

## 해결 — JOIN FETCH

```java
// StockIndicatorRepository.java
@Query("SELECT i FROM StockIndicator i JOIN FETCH i.company WHERE i.per IS NOT NULL AND i.pbr IS NOT NULL AND i.roe IS NOT NULL")
List<StockIndicator> findAllWithCompanyForScoring();
```

```java
// Top100Service.calculateAndSave()
List<StockIndicator> indicators = stockIndicatorRepository.findAllWithCompanyForScoring(); // 쿼리 1번으로 끝

List<StockIndicator> candidates = indicators.stream()
        .filter(i -> "Y".equals(i.getCompany().getCorpCls()))   // 추가 쿼리 없음 — 이미 채워져 있음
        .filter(i -> i.getCompany().getIndutyCode() != null)
        .filter(i -> i.getCompany().isFinancialIndustry()
                || (i.getFScore() != null && i.getFScore() >= F_SCORE_PASS_THRESHOLD))
        .collect(Collectors.toList());
```

`JOIN FETCH`는 SQL 표준 문법이 아니라 **JPQL(JPA 전용 쿼리 언어) 지시어**다. 실제로 DB에 나가는 SQL 자체는 평범한 `INNER JOIN`으로 번역되지만, Hibernate에게 "이 JOIN으로 읽은 연관 엔티티를 프록시가 아니라 즉시 채워진 실제 객체로 만들어라"고 지시하는 역할을 한다.

```sql
-- 번역된 SQL (Oracle의 페이징용 FETCH FIRST n ROWS와는 이름만 같을 뿐 무관한 개념)
SELECT i.*, c.*
FROM STOCK_INDICATOR i
INNER JOIN COMPANY c ON i.stock_code = c.stock_code
WHERE i.per IS NOT NULL AND i.pbr IS NOT NULL AND i.roe IS NOT NULL
```

결과: 지표 2,555건 + 기업정보를 **쿼리 1번**으로 가져오고, 이후 필터링 단계에서 `.getCompany()`를 아무리 호출해도 추가 쿼리가 발생하지 않는다.

## 왜 엔티티 매핑 자체를 EAGER로 되돌리지 않았나

`@OneToOne(fetch = LAZY)`는 **전역 기본 규칙**이고, `JOIN FETCH`는 **그 쿼리 하나에 한정된 예외 지정**이다.

- 매핑을 EAGER로 되돌리면: 기업정보가 필요 없는 다른 조회(`lowerPer5()`, `lowerPbr5()`, `higherRoe5()`, `higherDY5()` 등)에서도 항상 자동으로 JOIN/개별조회가 발생해 낭비가 생긴다.
- LAZY를 유지하고 TOP100 전용 쿼리에만 `JOIN FETCH`를 걸면: 평소엔 기업정보가 안 딸려오고(효율적), TOP100처럼 확실히 다 필요한 예외적 케이스에서만 그 쿼리 안에서 한 번에 가져온다.

즉 "기본은 아끼고, 확실히 필요한 곳만 콕 집어 한 번에 가져온다"가 이 설계의 핵심이다.

## 요약

```
Company에 무거운 연관관계 다수 존재
    → 평소 낭비 방지를 위해 @OneToOne 기본값(EAGER)을 LAZY로 명시 전환
    → (부작용) TOP100이 지표 + 기업정보(코스피 여부·업종코드)를 동시에 필요로 해서
       2,555건을 순회하며 매번 .getCompany() 호출
       → LAZY 프록시가 건마다 개별 쿼리 발생 (EAGER였어도 동일하게 발생했을 것)
       → 총 2,556번의 쿼리 (N+1)
    → Repository에 JOIN FETCH 전용 쿼리 추가, Service는 그 쿼리만 호출하도록 변경
    → 쿼리 1번으로 지표 + 기업정보를 한꺼번에 로딩, N+1 해소
```

**핵심 원칙**: N+1을 막는 명시는 연관 엔티티를 "쓰는" 코드(필터/순회 로직)가 아니라, 데이터를 처음 "가져오는" 조회 쿼리에서 해야 한다.

## 관련 코드

- [StockIndicator.java](../../../valuepick/src/main/java/com/example/demo/domain/entity/StockIndicator.java) — LAZY 매핑 선언부
- [Company.java](../../../valuepick/src/main/java/com/example/demo/domain/entity/Company.java) — 무거운 연관관계들이 걸려있는 엔티티
- [StockIndicatorRepository.java](../../../valuepick/src/main/java/com/example/demo/domain/repository/StockIndicatorRepository.java) — `JOIN FETCH` 쿼리 정의부
- [Top100Service.java](../../../valuepick/src/main/java/com/example/demo/domain/service/Top100Service.java) — 실제 필터링/스코어링 로직
