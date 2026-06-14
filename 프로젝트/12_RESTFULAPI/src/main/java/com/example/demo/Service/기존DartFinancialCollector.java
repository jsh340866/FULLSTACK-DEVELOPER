//package com.example.demo.Service;
//
//import com.example.demo.Dto.DartItem;
//import com.example.demo.Dto.DartResponse;
//import com.example.demo.Entity.Company;
//import com.example.demo.Entity.Financial;
//import com.example.demo.Repository.CompanyRepository;
//import com.example.demo.Repository.FinancialRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class 기존DartFinancialCollector {
//
//    // 외부 API 호출용
//    private final RestTemplate restTemplate;
//
//    // 회사 목록 조회용
//    private final CompanyRepository companyRepository;
//
//    // 재무 데이터 저장용
//    private final FinancialRepository financialRepository;
//
//    // DART API 키 (properties로 빼는 게 더 좋음)
//    @Value("${dart.api.key}")
//    private String apiKey;
//
//    private static final int SLEEP_MS = 200; // rate limit 방지
//    private static final int RETRY_COUNT = 3;
//
//    /**
//     * 📌 전체 재무 데이터 수집
//     * - DB에 있는 모든 회사 기준으로 DART API 호출
//     * - 연도 + 보고서 코드 기준으로 재무제표 저장
//     */
//    public void collect(String year, String reportCode) {
//
//        // 전체 회사 조회
//        List<Company> companies = companyRepository.findAll();
//
//        // 회사별로 DART API 호출
//        for (Company company : companies) {
//
//            try {
//                // API URL 생성
//                String url = buildUrl(company.getCorpCode(), year, reportCode);
//
//                // DART API 호출 (JSON → DartResponse 자동 변환)
//                ResponseEntity<DartResponse> response =
//                        restTemplate.getForEntity(url, DartResponse.class);
//
//                DartResponse body = response.getBody();
//
//                // API 실패 또는 응답 오류 체크
//                if (body == null || !"000".equals(body.getStatus())) {
//                    log.warn("API 실패 : {}", company.getCorpName());
//                    continue;
//                }
//
//                // 재무 데이터 변환 (DartItem → Financial)
//                Financial financial =
//                        mapToFinancial(company, body.getList(), Integer.parseInt(year));
//
//                // DB 저장
//                financialRepository.save(financial);
//
//                log.info("저장 완료 : {}", company.getCorpName());
//
//            } catch (Exception e) {
//                // 한 회사 실패해도 전체는 계속 진행
//                log.error("수집 실패 : {}", company.getCorpName(), e);
//            }
//        }
//    }
//
//    /**
//     * 📌 DART API URL 생성
//     */
//    private String buildUrl(String corpCode, String year, String reportCode) {
//
//        return "https://opendart.fss.or.kr/api/fnlttMultiAcnt.json"
//                + "?crtfc_key=" + apiKey
//                + "&corp_code=" + corpCode
//                + "&bsns_year=" + year
//                + "&reprt_code=" + reportCode;
//    }
//
//    /**
//     * 📌 DartItem 리스트 → Financial Entity 변환
//     * - accountNm 기준으로 필요한 값만 추출
//     */
//    private Financial mapToFinancial(Company company, List<DartItem> items, int year) {
//
//        // 재무상태표
//        Long assets = 0L;       // 자산
//        Long liabilities = 0L;  // 부채
//        Long equity = 0L;       // 자본
//
//        // 손익계산서
//        Long revenue = 0L;          // 매출
//        Long operatingProfit = 0L;  // 영업이익
//        Long netIncome = 0L;        // 당기순이익
//
//        // DART 계정명 기준 매핑
//        for (DartItem item : items) {
//
//            String name = item.getAccountNm();   // 계정명
//            Long value = parseAmount(item.getAmount()); // 금액 변환
//
//            if ("자산총계".equals(name)) assets = value;
//            else if ("부채총계".equals(name)) liabilities = value;
//            else if ("자본총계".equals(name)) equity = value;
//            else if ("매출액".equals(name)) revenue = value;
//            else if ("영업이익".equals(name)) operatingProfit = value;
//            else if ("당기순이익".equals(name)) netIncome = value;
//        }
//
//        // Financial Entity 생성
//        return Financial.builder()
//                .corpCode(company.getCorpCode())     // DART 기업 코드
//                .stockCode(company.getStockCode())   // 주식 코드
//                .year(year)                          // 기준 연도
//                .assets(assets)                      // 자산
//                .liabilities(liabilities)            // 부채
//                .equity(equity)                      // 자본
//                .revenue(revenue)                    // 매출
//                .operatingProfit(operatingProfit)    // 영업이익
//                .netIncome(netIncome)                // 순이익
//                .build();
//    }
//
//    /**
//     * 📌 문자열 금액 → Long 변환
//     * "1,234,567" → 1234567
//     */
//    private Long parseAmount(String amount) {
//
//        if (amount == null || amount.isEmpty()) {
//            return 0L;
//        }
//
//        return Long.parseLong(amount.replace(",", ""));
//    }
//}
