# 5. DART 대량 수집 — 페이지 배치 + 호출 간격 + 재시도

## 문제 상황

DART API로 전체 상장사(2,500개 이상)의 재무제표를 수집해야 하는데, `fnlttSinglAcntAll.json`은 회사 하나·연도 하나 단위로만 조회가 가능하다. 즉 전체 상장사를 수집하려면 회사 수만큼 개별 API 호출을 순차로 날려야 한다. 이 과정에서 대량 수집 특유의 문제가 세 가지 겹쳐서 나타났다.

1. **메모리 부담** — 전체 상장사를 한 번에 조회해서 리스트로 들고 있으면 수천 건짜리 컬렉션을 메모리에 유지해야 한다.
2. **API 호출 속도 제어** — 쉬지 않고 순차 호출하면 DART API 차단 위험이 있다.
3. **개별 요청의 불안정성** — 회사마다 재무제표 구조가 달라 응답이 아예 없는 경우(연결재무제표 자체가 없는 회사)가 있고, 네트워크·서버 오류로 요청 자체가 실패하는 경우도 있다.

## 적용된 해결책

### 1단계 — 페이지 배치로 메모리 부담 분산

```java
// DartFinancialCollector.doCollect()
int page = 0;
final int PAGE_SIZE = 100;

while (true) {
    Pageable pageable = PageRequest.of(page, PAGE_SIZE);
    Page<Company> companyPage = companyRepository.findAll(pageable);
    List<Company> companies = companyPage.getContent();

    if (companies.isEmpty()) break;

    for (Company company : companies) {
        // ... 회사별 처리
    }

    if (!companyPage.hasNext()) break;
    page++;
}
```

전체 상장사를 한 번에 조회하지 않고 `PAGE_SIZE=100` 단위로 페이징하며 순차 처리한다([DartFinancialCollector.doCollect()](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java#L85-L142)).

### 2단계 — 호출 간격으로 API 차단 방지

```java
private static final int SLEEP_MS = 100; // DART API 호출 간격 (차단 방지)
```

회사 하나를 처리할 때마다 `Thread.sleep(100ms)`를 넣어서([DartFinancialCollector.java:130](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java#L130)) DART API를 너무 빠르게 두드리지 않도록 했다. CFS 응답이 비어 OFS로 재시도할 때도 그 사이에 한 번 더 `sleep`을 넣는다([DartFinancialCollector.java:108](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java#L108)).

### 3단계 — 회사별 재무제표 구조 차이: CFS 실패 시 OFS로 폴백

```java
// CFS(연결재무제표) 먼저 시도, 자회사 없어 연결재무제표 자체가 없는 회사는 OFS(별도재무제표)로 재시도
DartResponse response = requestWithRetry(company.getCorpCode(), year, reprtCode, FS_DIV_CFS);
String finalFsDiv = FS_DIV_CFS;

if (!isValidResponse(response)) {
    Thread.sleep(SLEEP_MS);
    response = requestWithRetry(company.getCorpCode(), year, reprtCode, FS_DIV_OFS);
    finalFsDiv = FS_DIV_OFS;
}

if (!isValidResponse(response)) {
    log.warn("재무데이터 없음(CFS/OFS 모두): {}", company.getCorpName());
    continue;
}
```

자회사가 없는 회사는 연결재무제표(CFS) 자체가 존재하지 않아 `status="013"`(데이터 없음)이 돌아온다. 이 경우 별도재무제표(OFS)로 한 번 더 조회한다([DartFinancialCollector.java:103-116](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java#L103-L116)). 이건 "데이터가 없어서" 재시도하는 경우로, 아래 4단계의 "요청 자체가 실패해서" 재시도하는 경우와는 원인이 다르다.

### 4단계 — 네트워크/서버 오류: 지수적으로 늘어나는 대기시간으로 재시도

```java
private static final int RETRY_COUNT = 3;

private DartResponse requestWithRetry(String corpCode, String year, String reprtCode, String fsDiv) {
    String url = buildUrl(corpCode, year, reprtCode, fsDiv);

    for (int i = 0; i < RETRY_COUNT; i++) {
        try {
            ResponseEntity<DartResponse> response =
                    restTemplate.getForEntity(url, DartResponse.class);
            return response.getBody();

        } catch (Exception e) {
            log.warn("재시도 {}/{}", i + 1, RETRY_COUNT);
            try {
                Thread.sleep(500L * (i + 1)); // 재시도마다 대기시간 증가
            } catch (InterruptedException ignored) {}
        }
    }
    return null;
}
```

HTTP 요청 자체가 실패(타임아웃, 5xx 등 예외 발생)하면 `requestWithRetry()`에서 최대 3회까지 재시도한다. 대기시간을 500ms × 시도 횟수로 늘려가며(500ms → 1000ms → 1500ms) 재요청해서, 일시적인 서버 부하나 네트워크 문제로 연달아 실패하는 걸 완화했다([DartFinancialCollector.java:144-164](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java#L144-L164)).

### 5단계 — 재실행 안전성: 중복 저장 방지

```java
if (financialStatementRepository.findByStockCodeAndYearAndReprtCode(
        company.getStockCode(), dto.getBsnsYear(), reprtCode).isPresent()) {
    log.info("이미 존재, 스킵: {} ({}년)", company.getCorpName(), dto.getBsnsYear());
    continue;
}
financialStatementRepository.save(dto.toEntity(company));
```

배치 도중 실패해서 재실행하거나 스케줄러가 중복 트리거되는 경우를 대비해, 저장 전에 `findByStockCodeAndYearAndReprtCode`로 이미 저장된 연도 데이터인지 먼저 확인한다([DartFinancialCollector.java:119-125](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java#L119-L125)). 대량 수집처럼 오래 걸리고 중간 실패 가능성이 있는 배치에서는 재실행해도 안전하도록(idempotent) 만드는 게 중요했다.

## 결론

전체 상장사 재무제표 수집이라는 하나의 배치 작업 안에, 서로 다른 층위의 문제 세 가지가 겹쳐 있었다.

| 문제 | 원인 | 해결 |
|---|---|---|
| 메모리 부담 | 수천 건을 한 번에 조회 | `PAGE_SIZE=100` 페이지네이션 |
| API 차단 위험 | 호출 속도가 너무 빠름 | 회사당 `Thread.sleep(100ms)` |
| 데이터 자체가 없음 | 자회사 없어 CFS 미존재 | OFS로 폴백 재시도 |
| 요청 자체가 실패 | 네트워크/서버 오류 | 지수적 대기시간으로 최대 3회 재시도 |
| 중복 저장 | 재실행/중복 트리거 가능성 | 저장 전 존재 여부 확인 |

각각 원인이 다르기 때문에 해결 방식도 다르게 적용했다 — "느리게, 나눠서, 실패하면 다시" 라는 큰 틀 안에서 실패의 종류(데이터 없음 vs 요청 실패)를 구분해 각각 다른 재시도 로직을 붙인 게 핵심이다.

## 관련 코드

- [DartFinancialCollector.java](../../../valuepick/src/main/java/com/example/demo/domain/service/DartFinancialCollector.java) — `doCollect()`(페이지 배치), `requestWithRetry()`(HTTP 재시도), CFS/OFS 폴백 로직
