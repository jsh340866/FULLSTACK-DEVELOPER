# 6. 스케줄러 파이프라인 순서 보장 — cron 분 단위 스태거링

## 문제 상황

주가 수집 → 지표 계산 → TOP100 스코어링은 앞 단계 결과가 있어야 다음 단계가 의미 있는 **순차 파이프라인**이다. 그런데 `@Scheduled`는 각 스케줄러가 서로 독립적으로 트리거되는 방식이라, "A가 끝나야 B가 시작된다"는 순서를 코드로 강제할 방법이 없다.

이 제목 아래 실제로는 성격이 다른 문제 세 가지가 섞여 있었다.

1. **파이프라인 순서 보장** — 완료 신호 없이 어떻게 순서를 맞출 것인가.
2. **전 영업일자 계산** — 여러 스케줄러에서 반복되는 "어제 = 직전 영업일"이 항상 성립하지 않는 문제(월요일).
3. **외부 API 데이터 확정 시각과의 불일치** — 스케줄 시각에 원본 데이터가 아직 준비되지 않는 문제.

## 적용된 해결책

### 1단계 — cron 분 단위로 시간차를 벌려 순서 확보

```java
// StockPriceScheduler.collectStockPrice()
@Scheduled(cron = "0 0 14 * * MON-FRI", zone = "Asia/Seoul")

// IndicatorScheduler.calculateDaily()
// StockPriceScheduler(오후 2시) 수집 완료 후, Top100Scheduler(오후 2시 40분) 이전 - 평일 오후 2시 30분
@Scheduled(cron = "0 30 14 * * MON-FRI", zone = "Asia/Seoul")

// Top100Scheduler.calculateTop100()
// IndicatorScheduler(오후 2시 30분) 지표계산 완료 후 오후 2시 40분에 스코어 재계산
@Scheduled(cron = "0 40 14 * * MON-FRI", zone = "Asia/Seoul")
```

`StockPriceScheduler` **14:00** → `IndicatorScheduler` **14:30** → `Top100Scheduler` **14:40** 순으로 cron의 분(minute) 값을 의도적으로 벌려서, 앞 단계가 끝날 시간을 확보하는 방식을 택했다([StockPriceScheduler.java:23](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/StockPriceScheduler.java#L23), [IndicatorScheduler.java:20](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/IndicatorScheduler.java#L20), [Top100Scheduler.java:21](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/Top100Scheduler.java#L21)).

완료 이벤트를 기다리는 게 아니라 "이 정도 시간이면 끝나 있겠지"라는 시간차 확보이기 때문에, 앞 단계가 예상보다 오래 걸리면 순서가 깨질 수 있는 구조적 한계는 남아있다.

삭제 스케줄러들은 이 파이프라인과 무관하게 새벽 02:30(주가·코스피지수·환율), 02:35(TOP100)에 별도로 돈다. 삭제는 "cutoff 날짜 이전 데이터 지우기"라 실행 순서가 결과에 영향을 주지 않기 때문에, 수집 파이프라인과 시간대 자체를 분리해도 안전하다.

### 2단계 — "전 영업일자" 계산의 월요일 예외 처리

```java
// StockPriceScheduler, MarketIndexScheduler 등에서 반복
LocalDate baseDate = LocalDate.now().minusDays(
        LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY ? 3 : 1);
```

평소엔 어제가 직전 영업일이지만, 월요일엔 어제가 일요일이라 3일 전(금요일)으로 가야 한다. 이 로직이 [StockPriceScheduler.java:26-27](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/StockPriceScheduler.java#L26-L27), [MarketIndexScheduler.java:27-28](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/MarketIndexScheduler.java#L27-L28) 등 여러 스케줄러에 반복해서 들어가 있다.

이 로직은 주말만 처리하며, 공휴일은 다루지 못한다. 공휴일 대응은 [7번 트러블슈팅](../../../README2.md) — 환율 API의 빈 응답을 휴일 판별 신호로 재활용하는 방식으로 별도 처리된다.

### 3단계 — 사업보고서 활성 연도 판단

```java
// IndicatorScheduler.activeYear()
// 사업보고서는 매년 4월 1일에 전년도분이 수집되므로, 그 전엔 재작년(-2) 데이터가, 그 후엔 작년(-1) 데이터가 최신 재무제표임
private int activeYear() {
    LocalDate today = LocalDate.now();
    LocalDate collectionDate = LocalDate.of(today.getYear(), 4, 1);
    return today.isBefore(collectionDate) ? today.getYear() - 2 : today.getYear() - 1;
}
```

지표 계산(`IndicatorScheduler`)은 매일 도는데, 그 재료가 되는 사업보고서(`FinancialStatement`)는 매년 4월 1일에만 갱신된다. 그래서 4월 1일을 기준점 삼아 "지금 최신인 재무제표가 몇 년치인지"를 판단하게 했다([IndicatorScheduler.java:31-36](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/IndicatorScheduler.java#L31-L36)).

### 4단계 — MarketIndexScheduler를 파이프라인에서 분리

```java
// MarketIndexScheduler.collectMarketIndex()
@Scheduled(cron = "0 30 8 * * MON-FRI", zone = "Asia/Seoul")
```

`MarketIndexScheduler`(코스피 지수 수집)만 앞의 14:00대 파이프라인에서 떼어내 **08:30**에 독립적으로 돈다. 처음엔 다른 스케줄러들처럼 새벽 시간대(01:10)에 맞춰뒀는데, 실제 운영 로그를 보니 그 시각까지 KRX 지수 데이터가 확정되지 않아 `IllegalStateException`으로 매번 실패하고 있었다. KRX 확정 시각이 08:00 전후인 걸 확인하고 08:30으로 옮겨 여유를 뒀다([MarketIndexScheduler.java:24](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/MarketIndexScheduler.java#L24)).

이건 "앞 단계 완료를 기다린다"는 파이프라인 순서 문제가 아니라, **외부 API(KRX)의 데이터 확정 시각과 우리 스케줄 시각이 안 맞아서** 생긴 별개의 문제다. 원인이 다르기 때문에 해결도 "순서를 늦춘다"가 아니라 "파이프라인에서 분리해 독립적으로 돌린다"는 방식을 택했다.

## 결론

"스케줄러 시간 조정"이라는 제목 아래 원인이 다른 문제 세 가지가 섞여 있었다.

| 문제 | 원인 | 해결 |
|---|---|---|
| 파이프라인 순서 미보장 | `@Scheduled`는 독립 트리거, 완료 신호 없음 | cron 분 단위 스태거링(14:00 → 14:30 → 14:40) |
| 전 영업일자 계산 | 월요일엔 어제=일요일이라 직전 영업일 아님 | 월요일만 3일 전으로 보정(공휴일은 별도 로직) |
| 재무제표 활성 연도 판단 | 사업보고서는 연 1회, 지표계산은 매일 | 4월 1일 기준으로 조회 연도 분기 |
| 외부 API 데이터 미확정 | KRX 지수가 새벽 시각엔 아직 확정 안 됨 | 파이프라인에서 분리해 08:30 독립 실행 |

시간차로 순서를 맞추는 방식은 "확실한 보장"이 아니라 "충분한 여유를 둔 확률적 안전장치"라는 한계가 있다. 그럼에도 완료 이벤트/메시지 큐 같은 별도 인프라 없이 `@Scheduled` 패턴 안에서 문제를 해결하기 위해 택한 방식이다.

## 관련 코드

- [StockPriceScheduler.java](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/StockPriceScheduler.java) — 파이프라인 1단계(14:00), 전 영업일자 계산
- [IndicatorScheduler.java](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/IndicatorScheduler.java) — 파이프라인 2단계(14:30), `activeYear()` 연도 판단
- [Top100Scheduler.java](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/Top100Scheduler.java) — 파이프라인 3단계(14:40)
- [MarketIndexScheduler.java](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/MarketIndexScheduler.java) — 파이프라인에서 분리된 08:30 독립 스케줄
