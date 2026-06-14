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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    private static final int RETRY_COUNT = 2; // 실패 재시도 횟수

    /**
     * 전체 회사 재무 데이터 수집 실행
     */
    public void collect(String year, String reportCode) {

        int savedCount = 0;

        List<Company> companies = companyRepository.findAll(); // 전체 회사 조회

        for (Company company : companies) { // 회사 하나씩 반복

            try {

                DartResponse response = requestWithRetry( // API 호출 (재시도 포함)
                        company.getCorpCode(), // 기업코드
                        year, // 연도
                        reportCode // 보고서 코드
                );

                if (response == null || !"000".equals(response.getStatus())) { // API 실패 체크
                    log.warn("API 실패: {}", company.getCorpName()); // 실패 로그
                    continue; // 다음 회사로 이동
                }

                Financial financial = mapToFinancial( // DTO → Entity 변환
                        company, // 회사 정보
                        response.getList(), // 재무 데이터 리스트
                        Integer.parseInt(year) // 연도 변환
                );

                financialRepository.save(financial); // DB 저장

                log.info("저장 완료: {}", company.getCorpName()); // 성공 로그

                Thread.sleep(SLEEP_MS); // API 차단 방지 딜레이

                financialRepository.save(financial);
                savedCount++;


            } catch (Exception e) {

                log.error("처리 실패: {}", company.getCorpName(), e); // 개별 실패 로그
            }
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

    /**
     * DTO → Entity 변환
     */
    private Financial mapToFinancial(Company company, List<DartItem> items, int year) {

        Long assets = 0L; // 자산총계
        Long liabilities = 0L; // 부채총계
        Long equity = 0L; // 자본총계

        Long revenue = 0L; // 매출액
        Long operatingProfit = 0L; // 영업이익
        Long netIncome = 0L; // 당기순이익

        for (DartItem item : items) { // 계정별 데이터 반복

            String name = item.getAccountNm(); // 계정명
            Long value = parseAmount(item.getAmount()); // 금액 변환

            if ("자산총계".equals(name)) assets = value; // 자산
            else if ("부채총계".equals(name)) liabilities = value; // 부채
            else if ("자본총계".equals(name)) equity = value; // 자본
            else if ("매출액".equals(name)) revenue = value; // 매출
            else if ("영업이익".equals(name)) operatingProfit = value; // 영업이익
            else if ("당기순이익".equals(name)) netIncome = value; // 순이익
        }

        return Financial.builder() // Entity 생성
                .corpCode(company.getCorpCode()) // 기업코드
                .stockCode(company.getStockCode()) // 종목코드
                .year(year) // 연도
                .assets(assets) // 자산
                .liabilities(liabilities) // 부채
                .equity(equity) // 자본
                .revenue(revenue) // 매출
                .operatingProfit(operatingProfit) // 영업이익
                .netIncome(netIncome) // 순이익
                .build();
    }

    /**
     * 금액 문자열 → 숫자 변환
     */
    private Long parseAmount(String amount) {

        if (amount == null || amount.isBlank()) { // null 또는 빈값 처리
            return 0L; // 0 반환
        }

        return Long.parseLong(amount.replace(",", "")); // 콤마 제거 후 숫자 변환
    }
}