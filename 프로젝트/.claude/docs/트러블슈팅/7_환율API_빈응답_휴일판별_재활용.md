# 7. 환율 API의 "빈 응답"을 휴일 판별 신호로 재활용

## 문제 상황

TOP100/지표 계산에서 외화 재무제표를 원화로 환산하려면 매일 환율이 필요해서, `ExchangeScheduler`가 평일 새벽 01:00에 전 영업일자 환율을 수집한다. 그런데 전일 대비 변동률(`changeAmount`, `changeRate`)을 계산하려면 "가장 최근 영업일" 환율을 알아야 하는데, 한국수출입은행 환율 API는 주말·공휴일에 대해 **별도 플래그 없이 그냥 빈 배열**만 돌려준다.

캘린더 계산만으로는 공휴일(설날·추석 등)을 판단할 수 없다는 게 근본 문제였다. 요일로는 주말만 걸러낼 수 있고, 실제 휴장일 여부는 API를 호출해봐야 알 수 있다.

## 적용된 해결책

### 1단계 — 빈 응답을 예외로 승격시켜 "휴일 신호"로 변환

```java
// ExchangeRateApiService.callExchangeApi()
List<Map<String, Object>> response = restTemplate.getForObject(uri, List.class);

// 주말/공휴일이면 빈 배열 반환
if (response == null || response.isEmpty()) {
    throw new IllegalStateException("해당 날짜(" + searchDate + ")는 주말/공휴일이거나 환율 정보가 없습니다.");
}

// result 코드 검증 (1 = 성공)
Object firstResult = response.get(0).get("result");
if (firstResult != null && !"1".equals(String.valueOf(firstResult))) {
    throw new IllegalStateException("환율 API 호출 실패 (result 코드: " + firstResult + ")");
}
```

API 자체는 "이 날짜는 휴일이라 데이터가 없습니다"라고 명시적으로 알려주지 않는다. 대신 빈 배열이나 실패 `result` 코드를 돌려줄 뿐이다. `callExchangeApi()`는 이 두 경우를 모두 `IllegalStateException`으로 승격시켜서([ExchangeRateApiService.java:164-185](../../../valuepick/src/main/java/com/example/demo/domain/service/ExchangeRateApiService.java#L164-L185)), 호출하는 쪽에서 "이 날짜는 휴일"이라는 걸 캐치 가능한 신호로 받을 수 있게 만들었다.

### 2단계 — 예외를 캐치해 하루씩 거슬러 올라가며 재탐색

```java
// ExchangeRateApiService.findPreviousBusinessDayRates()
private static final int MAX_PREVIOUS_DAY_LOOKUP = 10;

private List<Exchange> findPreviousBusinessDayRates(LocalDate searchDate) {
    LocalDate candidate = searchDate.minusDays(1);

    for (int attempt = 0; attempt < MAX_PREVIOUS_DAY_LOOKUP; attempt++) {
        try {
            List<Exchange> dbRates = exchangeRepository.findByBaseDate(candidate);
            if (!dbRates.isEmpty()) {
                return dbRates;
            }
            return callExchangeApi(candidate.format(DATE_FORMAT));

        } catch (IllegalStateException e) {
            candidate = candidate.minusDays(1);
        }
    }
    throw new IllegalStateException("전 영업일 환율 정보를 찾을 수 없습니다 (최대 " + MAX_PREVIOUS_DAY_LOOKUP + "일 탐색).");
}
```

`IllegalStateException`을 "이 날짜는 휴일"이라는 의미로 캐치해서, 하루씩 더 과거로 이동하며 다시 시도한다([ExchangeRateApiService.java:136-160](../../../valuepick/src/main/java/com/example/demo/domain/service/ExchangeRateApiService.java#L136-L160)). 최대 `MAX_PREVIOUS_DAY_LOOKUP=10`일까지 탐색하는데, 설날·추석 같은 장기 연휴에도 전 영업일을 찾을 수 있도록 여유를 둔 값이다.

### 3단계 — DB 우선 조회로 불필요한 API 재호출 방지

```java
List<Exchange> dbRates = exchangeRepository.findByBaseDate(candidate);
if (!dbRates.isEmpty()) {
    log.info("전 영업일 DB 조회 성공: {}", candidate);
    return dbRates;
}
return callExchangeApi(candidate.format(DATE_FORMAT));
```

전 영업일 데이터는 전날 스케줄러가 이미 수집해 저장해뒀을 가능성이 높다. 그래서 후보 날짜마다 DB를 먼저 확인하고, DB에 없을 때만 API를 호출한다([ExchangeRateApiService.java:143-152](../../../valuepick/src/main/java/com/example/demo/domain/service/ExchangeRateApiService.java#L143-L152)). 매일 같은 날짜를 API로 반복 조회하는 낭비를 막았다.

### 4단계 — 전 영업일 데이터가 없어도 당일 환율은 저장

```java
// ExchangeRateApiService.getExchangeRateChanges()
if (previous != null) {
    double changeAmount = current.getDealBasR() - previous.getDealBasR();
    double changeRate = (changeAmount / previous.getDealBasR()) * 100;
    result.add(Exchange.builder()...changeAmount(changeAmount).changeRate(changeRate).build());
} else {
    // 전일 데이터 없으면 변동 없이 그대로 저장
    result.add(current);
}
```

전 영업일 탐색이 최악의 경우 실패하더라도(10일 내 못 찾음), 당일 환율 자체를 못 저장하는 건 막아야 한다. `previous`가 없으면 변동폭 계산 없이 당일 데이터만 그대로 저장하도록 분기했다([ExchangeRateApiService.java:105-127](../../../valuepick/src/main/java/com/example/demo/domain/service/ExchangeRateApiService.java#L105-L127)). 변동률 계산은 부가 정보이지, 당일 환율 저장 자체를 막을 이유는 아니라고 판단한 것이다.

## 결론

API가 명시적으로 알려주지 않는 정보(휴일 여부)를, 실패 응답을 뒤집어서 알아내는 방식으로 문제를 풀었다.

| 문제 | 원인 | 해결 |
|---|---|---|
| 휴일 여부를 API가 직접 안 알려줌 | 빈 배열/실패 코드로만 응답 | 빈 응답·실패 코드를 `IllegalStateException`으로 승격 |
| 전 영업일을 못 찾음 | 캘린더 계산으로 공휴일 판단 불가 | 예외를 캐치해 하루씩 거슬러 최대 10일 재탐색 |
| API 재호출 낭비 | 전 영업일 데이터가 이미 저장되어 있을 수 있음 | DB 우선 조회, 없을 때만 API 호출 |
| 탐색 실패 시 당일 데이터까지 유실 위험 | 변동률 계산과 저장 로직이 얽혀있으면 위험 | 전일 데이터 없으면 변동 없이 당일 값만 저장 |

[5번(DART 대량 수집)](5_DART_대량수집_페이지배치_재시도.md)의 재시도와는 재시도하는 이유 자체가 다르다. DART의 재시도(`requestWithRetry`)는 네트워크 오류 같은 **일시적 실패를 극복**하기 위한 반복이라 같은 요청을 그대로 다시 보낸다. 반면 여기서는 실패(빈 응답) 자체가 **"이 날짜는 휴일이다"라는 유의미한 정보**이고, 그 정보를 이용해 파라미터(날짜)를 바꿔가며 다음 시도를 하는 구조다 — 재시도가 아니라 탐색에 가깝다.

## 관련 코드

- [ExchangeRateApiService.java](../../../valuepick/src/main/java/com/example/demo/domain/service/ExchangeRateApiService.java) — `callExchangeApi()`(예외 승격), `findPreviousBusinessDayRates()`(재탐색), `getExchangeRateChanges()`(변동률 계산)
- [ExchangeScheduler.java](../../../valuepick/src/main/java/com/example/demo/domain/scheduled/ExchangeScheduler.java) — 평일 01:00 환율 수집 스케줄
