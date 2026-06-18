//package com.example.demo.Service;
//
//import com.example.demo.Entity.Company;
//import com.example.demo.Entity.Financial;
//import com.example.demo.Entity.FinancialIndicator;
//import com.example.demo.Entity.StockPrice;
//import com.example.demo.Repository.CompanyRepository;
//import com.example.demo.Repository.FinancialIndicatorRepository;
//import com.example.demo.Repository.FinancialRepository;
//import com.example.demo.Repository.StockPriceRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class 수정전FinancialIndicatorService {
//
//    private final CompanyRepository companyRepository;
//    private final FinancialRepository financialRepository;
//    private final StockPriceRepository stockPriceRepository;
//    private final FinancialIndicatorRepository financialIndicatorRepository;
//
//    /**
//     * 전체 회사 지표 계산 및 저장
//     */
//    public void calculateAll(int year) {
//
//        int savedCount = 0;
//        int page = 0;
//        final int PAGE_SIZE = 100; // 한 번에 처리할 회사 수
//
//        while (true) {
//
//            Pageable pageable = PageRequest.of(page, PAGE_SIZE); // 현재 페이지 번호와 사이즈로 Pageable 생성
//            Page<Company> companyPage = companyRepository.findAll(pageable); // 100건씩 DB에서 조회
//            List<Company> companies = companyPage.getContent(); // Page에서 실제 회사 리스트 추출
//
//            if (companies.isEmpty()) break; // 조회 결과 없으면 반복 종료
//
//            for (Company company : companies) {
//
//                try {
//
//                    Optional<Financial> financialOpt =
//                            financialRepository.findByStockCodeAndYear(company.getStockCode(), year); // 재무데이터 조회
//
//                    if (financialOpt.isEmpty()) { // 재무데이터 없으면 스킵
//                        log.warn("재무데이터 없음: {}", company.getCorpName());
//                        continue;
//                    }
//
//                    Optional<StockPrice> stockPriceOpt =
//                            stockPriceRepository.findTopByStockCodeOrderByTradeDateDesc(company.getStockCode()); // 최신 주가 조회
//
//                    if (stockPriceOpt.isEmpty()) { // 주가데이터 없으면 스킵
//                        log.warn("주가데이터 없음: {}", company.getCorpName());
//                        continue;
//                    }
//
//                    Financial financial = financialOpt.get();
//                    StockPrice stockPrice = stockPriceOpt.get();
//
//                    FinancialIndicator indicator = calculate(company, financial, stockPrice, year); // 지표 계산
//
//                    financialIndicatorRepository.save(indicator); // DB 저장
//                    savedCount++;
//                    log.info("지표 저장 완료: {} (page={}, total={})",
//                            company.getCorpName(), page, savedCount); // 저장 로그
//
//                } catch (Exception e) {
//                    log.error("지표 계산 실패: {}", company.getCorpName(), e);
//                }
//            }
//
//            if (!companyPage.hasNext()) break; // 마지막 페이지면 반복 종료
//            page++; // 다음 페이지로 이동
//        }
//
//        log.info("지표 계산 완료: {}건", savedCount);
//    }
//
//    /**
//     * 지표 계산 핵심 로직
//     */
//    private FinancialIndicator calculate(Company company, Financial financial,
//                                         StockPrice stockPrice, int year) {
//
//        long shareCount = company.getIstcTotqy(); // 발행주식수 (Company 테이블)
//        long closePrice = stockPrice.getClosePrice(); // 종가 (StockPrice 테이블)
//
//        long netIncome = financial.getThstrm_amount(); // 당기순이익 (Financial 테이블)
//        long equity = financial.getEquity(); // 자본총계
//        long liabilities = financial.getLiabilities(); // 부채총계
//        long operatingProfit = financial.getOperatingProfit(); // 영업이익
//        long revenue = financial.getRevenue(); // 매출액
//        long marketCap = closePrice * shareCount; // 시가총액
//
//
//        // EPS: 주당순이익 = 순이익 / 발행주식수
//        Double eps = safeDiv(netIncome, shareCount);
//
//        // BPS: 주당순자산 = 자본총계 / 발행주식수
//        Double bps = safeDiv(equity, shareCount);
//
//        // PER: 주가수익비율 = 주가 / EPS
//        Double per = (eps != null && eps != 0) ? closePrice / eps : null;
//
//        // PBR: 주가순자산비율 = 주가 / BPS
//        Double pbr = (bps != null && bps != 0) ? closePrice / bps : null;
//
//        // ROE: 자기자본이익률 = 순이익 / 자본총계 * 100
//        Double roe = (equity != 0) ? (double) netIncome / equity * 100 : null;
//
//        // 부채비율 = 부채총계 / 자본총계 * 100
//        Double debtRatio = (equity != 0) ? (double) liabilities / equity * 100 : null;
//
//        // 영업이익률 = 영업이익 / 매출액 * 100
//        Double operatingProfitMargin = (revenue != 0) ? (double) operatingProfit / revenue * 100 : null;
//
//        // 배당수익률 = 별도 배당 데이터 필요 → 현재 null 처리
//        Double dividendYield = null;
//
//        return FinancialIndicator.builder()
//                .corpCode(company.getCorpCode())
//                .stockCode(company.getStockCode())
//                .year(year)
//                .eps(eps)
//                .bps(bps)
//                .per(per)
//                .pbr(pbr)
//                .roe(roe)
//                .debtRatio(debtRatio)
//                .operatingProfitMargin(operatingProfitMargin)
//                .dividendYield(dividendYield)
//                .marketCap(marketCap)
//                .build();
//    }
//
//    /**
//     * 0 나누기 방지 유틸
//     */
//    private Double safeDiv(long numerator, long denominator) {
//        if (denominator == 0) return null; // 분모가 0이면 null 반환
//        return (double) numerator / denominator;
//    }
//}