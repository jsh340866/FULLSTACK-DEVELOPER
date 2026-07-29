# 작업 진행 체크리스트 (2026-07-29 기준)

새 세션에서 이어서 작업할 때 참고. 전체 설계 원본은 `../프로젝트/.claude/spark프로젝트/PROJECT_INSTRUCTIONS.md`.

## 완료

### 인프라
- [x] 리포 기본 구조 생성 (`docker/`, `jobs/`, `conf/`, `notebooks/`, `docs/`, `data/`)
- [x] `.gitignore` — `data/`, `.env`, Python/Spark 캐시 제외
- [x] `requirements.txt` — pyspark, requests, PyYAML
- [x] `docker/docker-compose.yml` — spark-master + worker×2(각 2코어) + jupyter + mysql(3307, 기존 ValuePick MySQL 3306과 충돌 방지)
- [x] `docker/.env.example` — MySQL 비밀번호 등 민감정보 분리
- [x] `conf/spark-defaults.conf` — shuffle partition(4, 워커 총 4코어 기준), broadcast join 임계값(10MB)
- [x] `docker compose config`로 문법 검증 완료
- [x] `README.md` — 진행 상태 + 실행 방법

### jobs/01_ingest_raw.py
- [x] KRX 상장종목 수집 (`fetch_krx_listed`) — JSON, KOSPI/KOSDAQ 필터, 스팩·리츠 제외
- [x] DART corpCode 매핑 (`fetch_dart_corp_code_map`) — ZIP 안 XML 파싱 (DART 자체 스펙상 유일한 XML 응답)
- [x] 주가 수집 (`fetch_stock_prices`) — JSON, 기준일 1회 호출로 전 종목 수신
- [x] DART 재무제표 수집 (`fetch_financial_statement`) — CFS 우선, 없으면 OFS 재시도 (재시도 3회)
- [x] DART 배당 수집 (`fetch_dividend`) — 재시도 1회
- [x] 재수집 방지 로직 (`already_ingested`) — DART 일일 콜 제한(10,000콜) 대응
- [x] Parquet 저장 (companies/prices/financials/dividends, year 파티셔닝)
- [x] API 키는 환경변수(`DART_API_KEY`, `STOCK_API_KEY`)로만 주입, 하드코딩 없음

기존 ValuePick(Spring Boot) 재사용 대상 파일 — 엔드포인트/인증/파싱만 참고, MySQL 저장 로직은 미사용:
- `valuepick/.../service/StockPriceCollector.java`
- `valuepick/.../service/DartCompanyCollector.java`
- `valuepick/.../service/DartFinancialCollector.java`
- `valuepick/.../service/DividendCollector.java`

### 진행 중 정정한 사항
- CLAUDE.md에는 "공공데이터포털 주가 API = XML 파싱"이라 적혀 있었으나, 실제 `StockPriceCollector.java`를 읽어보니 `resultType=json`으로 JSON을 바로 받고 있음. XML 파싱이 실제로 필요한 곳은 DART `corpCode.xml`(ZIP 압축) 하나뿐. 이 기준으로 코드 작성함.

## 미완료 (지침서 섹션 6 순서대로)

- [ ] 3. `jobs/02_clean_prices.py` — 결측치 보간, 액면분할 반영, 거래정지 구간 처리 (`groupBy("stock_code")` 기반 병렬화)
- [ ] 3. `jobs/03_build_indicators.py` — PER/PBR/ROE/배당수익률 계산, `Window.partitionBy("stock_code").orderBy("date")` 사용
  - 참고: 기존 계산 로직은 `valuepick/.../service/FinancialIndicatorService.java`에 있음 (EPS/BPS/PER/PBR/ROE/부채비율/배당수익률/ROA/모멘텀/F-Score/EPS성장률)
- [ ] 4. `notebooks/verify_indicators.ipynb` — 03 결과와 `FinancialIndicatorService` 계산값 대조, 불일치 시 원인 규명 필수
- [ ] 5. `conf/strategies.yaml` — 전략 파라미터 그리드 정의 (PER상한×PBR상한×배당수익률하한×리밸런싱주기×보유종목수, 최소 500 조합)
- [ ] 6. `jobs/04_backtest_grid.py` — 프로젝트 핵심. 튜닝 없는 최초 버전 → 실행시간 측정 → 브로드캐스트조인/파티션수/캐싱 튜닝 적용 → 재측정. **튜닝 전 수치를 반드시 먼저 실측**(나중에 추정 금지). 룩어헤드 바이어스 방지(`report_date <= rebalance_date`) 필수
- [ ] 7. `jobs/05_export_to_mysql.py` — Spark JDBC writer로 `backtest_results`, `strategy_performance` 테이블 upsert
- [ ] 8. `docs/PERFORMANCE.md`, `docs/ARCHITECTURE.md`, `docs/VALIDATION.md` — 진행하면서 계속 갱신 (마지막에 몰아쓰지 않기)

## 하지 말아야 할 것 (지침서 7항)
- 기존 ValuePick의 Entity/DTO/스케줄러 직접 수정 금지
- MySQL을 Spark 잡 간 중간 데이터 전달 용도로 사용 금지 (전부 Parquet)
- 리밸런싱 시점 이후 공시된 재무 데이터 사용 금지 (룩어헤드 바이어스)
- 튜닝 먼저 적용하고 "전" 수치를 나중에 추정해서 기록 금지