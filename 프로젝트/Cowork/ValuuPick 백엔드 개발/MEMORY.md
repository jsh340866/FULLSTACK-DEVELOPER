# ValuuPick 백엔드 개발 Memory

Last updated: 2026-06-27

## 관련 인물

- 본인 — Spring Boot 백엔드 개발 담당 (Backend 2명 중 1명). 담당: 외부 Open API 연동, Scheduler, 데이터 수집/가공, DTO↔Entity 변환, DB 저장, Async 처리, 성능 개선, 중복 처리.
- 백엔드 팀원 1명 — 역할 미확정 (추가 정보 필요).
- 로그인/인증(Spring Security, OAuth2) 담당 팀원 — 별도 인원.
- 프론트엔드 2명 — React 담당.

## 주요 결정사항

- Tech Stack: Java 21, Spring Boot 3, Spring Data JPA, MySQL, JWT, Lombok (Backend) / React (Frontend).
- 연동 Open API: DART, 공공데이터, 한국수출입은행, KRX 정보데이터시스템 (계속 추가 예정).
- 현재 데이터 처리 흐름: Scheduler → Open API 호출 → XML/JSON 응답 → (XML은 JSON으로 변환) → DTO 생성 → Entity 변환 → DB 저장 → 필요 시 분석 데이터로 가공 저장.
- 현재는 순차 호출 방식. 향후 @Async, CompletableFuture, 병렬 API 호출, ThreadPool, Batch 처리로 성능 개선 고려 중.
- API 호출 실패 시 try-catch로 예외 처리 + 로그 기록 + 필요 시 재시도. 동일 데이터 중복 저장 방지.
- 프로젝트 규모(2026-06-27 기준): 기업 약 3,000개, 재무 데이터 3,000건 이상, 배당 데이터 1,000건 이상.
- 기본 코드 스타일: Builder Pattern, `@RequiredArgsConstructor`, `JpaRepository`, `@Transactional`, RESTful API.
