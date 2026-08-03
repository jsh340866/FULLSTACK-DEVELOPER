# 2. DART 수집 전용 `@Async` 스레드풀

## 문제 상황

주가 수집과 DART 수집(재무제표·기업정보·배당)이 스레드풀 하나를 공유하면, DART 수집처럼 오래 걸리는 작업이 스레드를 점유하는 동안 주가 수집 같은 다른 비동기 작업이 큐에서 밀려 지연될 수 있다.

## 적용된 해결책

[AsyncConfig.java](../../../valuepick/src/main/java/com/example/demo/config/AsyncConfig.java)에서 `stockExecutor`(주가용)와 `dartExecutor`(DART용)를 완전히 분리된 스레드풀로 만들었다.

```java
@Bean("stockExecutor")   // core 8 / max 15 / queue 50
public Executor stockExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(8);
    executor.setMaxPoolSize(15);
    executor.setQueueCapacity(50);
    executor.setThreadNamePrefix("stock-");
    executor.initialize();
    return executor;
}

@Bean("dartExecutor")    // core 8 / max 15 / queue 100
public Executor dartExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(8);
    executor.setMaxPoolSize(15);
    executor.setQueueCapacity(100);
    executor.setThreadNamePrefix("dart-");
    executor.initialize();
    return executor;
}
```

`DartFinancialCollector`, `DartCompanyCollector`, `DividendCollector` 세 서비스가 모두 `@Async("dartExecutor")`로 이 풀을 공유하며, `stockExecutor`와는 완전히 격리된다.

## 비동기 처리 자체는 타당함

[DartFinancialCollector.doCollect()](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java#L85)와 [DartCompanyCollector.collectIndustryInfo()](../../../valuepick/src/main/java/com/example/demo/domain/service/DartCompanyCollector.java#L194)는 회사 수천 개를 순회하며 매 건마다 `Thread.sleep(100ms)`를 넣는 구조라, 상장사 2,555개 기준 최소 4분 이상 걸리는 작업이다. 동기로 처리하면 호출부(스케줄러/API)가 그만큼 블로킹되므로, `@Async`로 백그라운드 처리하는 접근 자체는 근거가 있다.

## 근거가 불명확한 부분 (코드로 확인 불가)

### `queueCapacity=100`이라는 구체적 숫자

`ThreadPoolTaskExecutor`의 처리 순서는 다음과 같다.

1. core 스레드가 비어있으면 즉시 새 스레드로 실행
2. core가 다 바쁘면 새 스레드를 늘리지 않고 먼저 **큐**에 작업을 쌓음
3. 큐까지 꽉 차야 max까지 스레드를 늘림
4. max도 다 차고 큐도 꽉 차면 `RejectedExecutionException`으로 거절

이 구조에서 "큐 1자리 = `@Async` 메서드 호출 1건"이다. 그런데 이 프로젝트의 `doCollect()`나 `collectIndustryInfo()`는 회사 수천 개를 **메서드 하나 안에서** `while(true)` 순차 반복문으로 처리하기 때문에, 회사 건수 자체가 큐를 직접 채우지 않는다. 큐를 채우려면 서로 다른 `@Async("dartExecutor")` 호출이 짧은 시간에 여러 번 겹쳐야 하는데, 이 프로젝트에서 그런 메서드는 많아야 한 자릿수~십몇 개 수준이라 100이라는 큐 크기를 정당화할 근거가 코드상으로는 보이지 않는다.

### `stockExecutor`와 `dartExecutor`의 core/max가 동일한 이유

둘 다 core 8, max 15로 완전히 같고 queue만 다르다. "성격이 다른 두 작업이라 다른 크기가 필요했다"는 설명과는 맞지 않으며, 값을 그대로 복사해서 이름만 바꿨을 가능성이 있다.

### 코드 주석과 실제 값의 불일치

[AsyncConfig.java:36-39](../../../valuepick/src/main/java/com/example/demo/config/AsyncConfig.java#L36) 주석에는 "corePoolSize=5"라고 적혀있지만 실제 값은 `setCorePoolSize(8)`이다. 동작에는 영향 없는 단순 주석 오타로 보인다.

## 결론

스레드풀을 용도별로 분리한 설계 방향(주가/DART 격리) 자체는 타당한 근거가 있다. 다만 `queueCapacity=100` 같은 구체적인 튜닝 수치가 실제 부하 패턴에 근거해 정해졌는지는 코드만으로 확인할 수 없다. 이 값을 검증하려면 운영 중 `dartExecutor`의 큐 사용량 로그나 모니터링 지표를 실측해야 하며, 현재 코드베이스에는 그 근거가 없다.

## 관련 코드

- [AsyncConfig.java](../../../valuepick/src/main/java/com/example/demo/config/AsyncConfig.java) — 스레드풀 정의
- [DartFinancialCollector.java](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java) — `@Async("dartExecutor")` 사용부
- [DartCompanyCollector.java](../../../valuepick/src/main/java/com/example/demo/domain/service/DartCompanyCollector.java) — `@Async("dartExecutor")` 사용부
- [DividendCollector.java](../../../valuepick/src/main/java/com/example/demo/domain/service/DividendCollector.java) — `@Async("dartExecutor")` 사용부
