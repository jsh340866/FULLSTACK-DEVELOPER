package com.example.demo.Service;


import com.example.demo.Dto.DartItem;
import com.example.demo.Dto.DartResponse;
import com.example.demo.Entity.Company;
import com.example.demo.Entity.Financial;
import com.example.demo.Repository.CompanyRepository;
import com.example.demo.Repository.FinancialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;

@Service
@RequiredArgsConstructor // final 필드 생성자 자동 생성
@Slf4j
public class DartFinancialCollector {

    private final RestTemplate restTemplate; // API 호출용
    private final CompanyRepository companyRepository; // 회사 조회
    private final FinancialRepository financialRepository; // 재무 저장

    @Value("${dart.api.key}") // DART API 키
    private String apiKey;

    private static final int SLEEP_MS = 100; // 호출 간격 (차단 방지)
    private static final int RETRY_COUNT = 1; // 실패 재시도 횟수


    /**
     * 전체 회사 재무 데이터 수집 실행
     */
    public void collect(String year, String reportCode) {

        int savedCount = 0;
        int page = 0;
        final int PAGE_SIZE = 100; // 한 번에 조회할 회사 수

        while (true) { // 페이지 단위로 반복

            Pageable pageable = PageRequest.of(page, PAGE_SIZE); // 현재 페이지 번호와 사이즈로 Pageable 생성
            Page<Company> companyPage = companyRepository.findAll(pageable); // 100건씩 DB에서 조회
            List<Company> companies = companyPage.getContent(); // Page에서 실제 회사 리스트 추출

            if (companies.isEmpty()) break; // 조회 결과 없으면 반복 종료

            for (Company company : companies) { // 조회된 회사 하나씩 처리

                try {

                    DartResponse response = requestWithRetry( // API 호출 (재시도 포함)
                            company.getCorpCode(),
                            year,
                            reportCode
                    );




                    if (response == null || !"000".equals(response.getStatus())) { // API 실패 체크
                        log.warn("API 실패: {}", company.getCorpName());
                        continue; // 다음 회사로 이동
                    }

                    Financial financial = mapToFinancial( // DTO → Entity 변환
                            company,
                            response.getList(),
                            Integer.parseInt(year)
                    );

                    if (financialRepository.findByStockCodeAndYear(
                            company.getStockCode(), Integer.parseInt(year)).isPresent()) {
                        log.info("이미 존재, 스킵: {}", company.getCorpName()); // 중복이면 스킵
                        continue;
                    }

                    financialRepository.save(financial); // 없을 때만 저장
                    savedCount++;

                    log.info("저장 완료: {} (page={}, total={})",
                            company.getCorpName(), page, savedCount);
                    Thread.sleep(SLEEP_MS); // API 차단 방지 딜레이

                } catch (Exception e) {
                    log.error("처리 실패: {}", company.getCorpName(), e);
                }
            }

            if (!companyPage.hasNext()) break; // 마지막 페이지면 반복 종료
            page++; // 다음 페이지로 이동
        }

        log.info("Financial 저장 완료: {}건", savedCount);
    }


    /**
     * DART API 호출 (재시도 포함)
     */
    private DartResponse requestWithRetry(String corpCode, String year, String reportCode) {

        String url = buildUrl(corpCode, year, reportCode); // API URL 생성

        for (int i = 0; i < RETRY_COUNT; i++) { // 최대 3회 시도

            try {

                ResponseEntity<DartResponse> response =
                        restTemplate.getForEntity(url, DartResponse.class); // API 호출

                return response.getBody(); // 성공 시 반환

            } catch (Exception e) {

                log.warn("재시도 {}/{}", i + 1, RETRY_COUNT); // 재시도 로그

                try {
                    Thread.sleep(500L * (i + 1)); // 점점 늘어나는 대기시간
                } catch (InterruptedException ignored) {}
            }
        }

        return null; // 전부 실패 시 null 반환
    }

    // URL 직접 받는 메서드 추가
    private DartResponse requestWithRetry(String url) {

        for (int i = 0; i < RETRY_COUNT; i++) {

            try {
                ResponseEntity<DartResponse> response =
                        restTemplate.getForEntity(url, DartResponse.class); // 배당 URL로 호출
                return response.getBody();

            } catch (Exception e) {
                log.warn("재시도 {}/{}", i + 1, RETRY_COUNT);
                try {
                    Thread.sleep(500L * (i + 1));
                } catch (InterruptedException ignored) {}
            }
        }
        return null;
    }

    /**
     * DART API URL 생성
     */
    private String buildUrl(String corpCode, String year, String reportCode) {

        return "https://opendart.fss.or.kr/api/fnlttMultiAcnt.json"
                + "?crtfc_key=" + apiKey // API 키
                + "&corp_code=" + corpCode // 기업 코드
                + "&bsns_year=" + year // 사업 연도
                + "&reprt_code=" + reportCode; // 보고서 코드
    }

    // 배당 API URL 생성
    private String buildDividendUrl(String corpCode, String year, String reportCode) {
        return "https://opendart.fss.or.kr/api/alotMatter.json"
                + "?crtfc_key=" + apiKey
                + "&corp_code=" + corpCode
                + "&bsns_year=" + year
                + "&reprt_code=" + reportCode;
    }

    /**
     * DTO → Entity 변환
     */
    private Financial mapToFinancial(Company company, List<DartItem> items, int year) {

        // CFS(연결) 우선, 없으면 OFS(별도) 사용
        Map<String, Long> cfsMap = new HashMap<>();
        Map<String, Long> ofsMap = new HashMap<>();

        for (DartItem item : items) {
            String name = item.getAccountNm();
            Long value = parseAmount(item.getAmount());
            String fsDiv = item.getFsDiv(); // "CFS" or "OFS"

            if ("CFS".equals(fsDiv)) {
                cfsMap.put(name, value);
            } else if ("OFS".equals(fsDiv)) {
                ofsMap.put(name, value);
            }
        }

        // CFS 우선, 없으면 OFS, 둘 다 없으면 0
        Long assets          = getValue(cfsMap, ofsMap, "자산총계");
        Long liabilities     = getValue(cfsMap, ofsMap, "부채총계");
        Long equity          = getValue(cfsMap, ofsMap, "자본총계");
        Long revenue         = getValue(cfsMap, ofsMap, "매출액");
        Long operatingProfit = getValue(cfsMap, ofsMap, "영업이익");
        Long thstrm_amount   = getValue(cfsMap, ofsMap, "당기순이익(손실)");

        return Financial.builder()
                .corpCode(company.getCorpCode())
                .stockCode(company.getStockCode())
                .year(year)
                .assets(assets)
                .liabilities(liabilities)
                .equity(equity)
                .revenue(revenue)
                .operatingProfit(operatingProfit)
                .thstrm_amount(thstrm_amount)
                .build();
    }

    /**
     * 금액 문자열 → 숫자 변환
     */
    private Long parseAmount(String amount) {

        if (amount == null || amount.isBlank() || "-".equals(amount.trim())) { // null, 빈값, "-" 모두 처리
            return 0L;
        }

        return Long.parseLong(amount.replace(",", "")); // 콤마 제거 후 숫자 변환
    }

    // CFS 우선, 없으면 OFS, 둘 다 없으면 0
    private Long getValue(Map<String, Long> cfsMap, Map<String, Long> ofsMap, String accountNm) {
        if (cfsMap.containsKey(accountNm)) return cfsMap.get(accountNm);
        if (ofsMap.containsKey(accountNm)) return ofsMap.get(accountNm);
        return 0L;
    }

}