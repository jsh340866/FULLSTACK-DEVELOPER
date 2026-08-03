# 4. 금융업 F-Score 예외 처리

## 문제 상황

TOP100 후보를 정할 때 Piotroski F-Score(9점 만점 중 6점 이상만 통과)를 재무 건전성 필터로 쓴다. 그런데 F-Score를 구성하는 항목 중 유동비율·매출총이익률 등은 제조업의 재무구조(원자재를 사서 제품을 만들어 파는 구조)를 전제로 설계된 지표다.

은행·보험사 같은 금융업은 예금·대출이 주력 사업이라 사업 구조 자체가 다르고, "매출총이익률"·"유동비율" 같은 개념이 애초에 제조업 기준으로는 의미가 없거나 왜곡된 값이 나온다. F-Score를 금융업에도 똑같이 적용하면, 재무구조가 멀쩡한 금융회사가 단순히 F-Score 계산 방식과 안 맞아서 부당하게 탈락하는 문제가 생긴다.

## 적용된 해결책

### 1단계 — 금융업 판별 로직

```java
// Company.java
// induty_code 앞 2자리(KSIC 중분류) 64=금융업/65=보험 및 연금업/66=금융 및 보험관련 서비스업
// 금융업은 유동비율·매출총이익률 등 F-Score 항목 구조 자체가 안 맞아 F-Score 계산을 스킵할 때 사용
public boolean isFinancialIndustry() {
    if (indutyCode == null || indutyCode.length() < 2) return false;
    String prefix = indutyCode.substring(0, 2);
    return "64".equals(prefix) || "65".equals(prefix) || "66".equals(prefix);
}
```

`induty_code`(표준산업분류코드, KSIC) 앞 2자리가 **64(금융업)/65(보험 및 연금업)/66(금융 및 보험관련 서비스업)** 이면 금융업으로 판단한다. 이 코드 체계는 [DartCompanyCollector.INDUTY_NAME_MAP](../../../valuepick/src/main/java/com/example/demo/domain/service/DartCompanyCollector.java#L102-104)에 정의된 매핑과 동일하다.

### 2단계 — F-Score 필터에서 금융업을 예외로 통과

```java
// Top100Service.calculateAndSave()
List<StockIndicator> candidates = indicators.stream()
        .filter(i -> "Y".equals(i.getCompany().getCorpCls()))         // ① 코스피만
        .filter(i -> i.getCompany().getIndutyCode() != null)          // ② 업종 판별 불가 종목 제외
        .filter(i -> i.getCompany().isFinancialIndustry()             // ③ 금융업은 F-Score 예외 통과
                || (i.getFScore() != null && i.getFScore() >= F_SCORE_PASS_THRESHOLD))
        .collect(Collectors.toList());
```

`isFinancialIndustry() || (F-Score 조건)` 형태의 OR 조건이라, **금융업이면 F-Score 값이 무엇이든(계산조차 안 됐어도) 뒤쪽 조건은 평가하지 않고 무조건 통과**한다. 금융업이 아닌 경우에만 F-Score ≥ 6 조건이 실제로 적용된다.

애초에 금융업 종목은 F-Score 자체를 계산하지 않아 `getFScore()`가 항상 `null`이다. 만약 "금융업이면 F-Score 6점 이상 조건을 적용"하는 로직이었다면 `getFScore() != null` 검사에서 전부 걸려 탈락했을 것이다. 실제로는 그 반대로, 금융업은 F-Score 조건 자체를 완전히 건너뛰고 무조건 통과시킨다.

| | 실제 동작 |
|---|---|
| 금융업 (64/65/66) | F-Score 검사 자체를 안 함 — 무조건 통과 |
| 비금융업 | F-Score가 null이 아니고 6점 이상이어야 통과 |

### 3단계 — 업종코드 미수집 종목은 아예 후보에서 제외

```java
.filter(i -> i.getCompany().getIndutyCode() != null)  // ②
```

`isFinancialIndustry()`는 `indutyCode == null`이면 무조건 `false`를 반환한다. 만약 이 ②번 필터가 없다면, 아직 DART에서 업종코드가 수집되지 않은 진짜 금융업 종목이 `isFinancialIndustry() == false`로 오판되고, 이어서 F-Score 조건(`getFScore() != null && ...`)도 null이라 실패해 **부당하게 탈락**하게 된다.

그래서 ②번 필터로 업종 판별이 불가능한 종목을 먼저 제외해, ③번의 "금융업 여부 판단"이 항상 신뢰할 수 있는 상태에서만 F-Score 예외 처리가 적용되도록 순서를 잡았다.

## 결론

금융업(64/65/66)은 F-Score 계산 자체가 구조적으로 맞지 않아 계산을 스킵하고, TOP100 필터에서도 F-Score 조건 없이 무조건 통과시킨다. 업종코드가 아직 수집되지 않아 금융업 여부 자체를 판단할 수 없는 종목은 이 예외 처리의 공정성을 보장할 수 없으므로 후보에서 아예 제외한다.

## 관련 코드

- [Company.java](../../../valuepick/src/main/java/com/example/demo/domain/entity/Company.java) — `isFinancialIndustry()` 판별 로직
- [Top100Service.java](../../../valuepick/src/main/java/com/example/demo/domain/service/Top100Service.java) — `calculateAndSave()` 필터 체인
- [DartCompanyCollector.java](../../../valuepick/src/main/java/com/example/demo/domain/service/DartCompanyCollector.java) — `induty_code` → 업종명 매핑(`INDUTY_NAME_MAP`)
