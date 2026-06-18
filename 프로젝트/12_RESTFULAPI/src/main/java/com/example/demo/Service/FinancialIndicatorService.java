package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FinancialIndicatorService {

    private final CompanyRepository companyRepository;
    private final FinancialRepository financialRepository;
    private final StockPriceRepository stockPriceRepository;
    private final FinancialIndicatorRepository financialIndicatorRepository;
    private final DividendRepository dividendRepository; // 배당 데이터 조회

    public void calculateAll(int year) {

        int savedCount = 0;
        int page = 0;
        final int PAGE_SIZE = 100;

        while (true) {

            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            Page<Company> companyPage = companyRepository.findAll(pageable);
            List<Company> companies = companyPage.getContent();

            if (companies.isEmpty()) break;

            for (Company company : companies) {

                try {

                    Optional<Financial> financialOpt =
                            financialRepository.findByStockCodeAndYear(company.getStockCode(), year); // 해당 연도 재무데이터 조회

                    if (financialOpt.isEmpty()) {
                        log.warn("재무데이터 없음: {}", company.getCorpName());
                        continue;
                    }

                    Optional<StockPrice> stockPriceOpt =
                            stockPriceRepository.findTopByStockCodeOrderByTradeDateDesc(company.getStockCode()); // 가장 최신 주가 조회

                    if (stockPriceOpt.isEmpty()) {
                        log.warn("주가데이터 없음: {}", company.getCorpName());
                        continue;
                    }

                    Financial financial = financialOpt.get();
                    StockPrice stockPrice = stockPriceOpt.get();

                    FinancialIndicator indicator = calculate(company, financial, stockPrice, year); // 지표 계산

                    financialIndicatorRepository.save(indicator);
                    savedCount++;
                    log.info("지표 저장 완료: {} (page={}, total={})", company.getCorpName(), page, savedCount);

                } catch (Exception e) {
                    log.error("지표 계산 실패: {}", company.getCorpName(), e);
                }
            }

            if (!companyPage.hasNext()) break;
            page++;
        }

        log.info("지표 계산 완료: {}건", savedCount);
    }

    private FinancialIndicator calculate(Company company, Financial financial,
                                         StockPrice stockPrice, int year) {

        // ── 기초 데이터 추출 ──────────────────────────────────────────
        long shareCount      = company.getIstcTotqy();         // 발행주식수
        long closePrice      = stockPrice.getClosePrice();      // 최신 종가
        long netIncome       = financial.getThstrm_amount();    // 당기순이익
        long equity          = financial.getEquity();           // 자본총계
        long liabilities     = financial.getLiabilities();      // 부채총계
        long operatingProfit = financial.getOperatingProfit();  // 영업이익
        long revenue         = financial.getRevenue();          // 매출액

        // ── 시가총액 = 종가 × 발행주식수 ─────────────────────────────
        long marketCap = closePrice * shareCount;

        // ── EPS (주당순이익) = 당기순이익 / 발행주식수 ───────────────
        Double eps = safeDiv(netIncome, shareCount);

        // ── BPS (주당순자산) = 자본총계 / 발행주식수 ─────────────────
        Double bps = safeDiv(equity, shareCount);

        // ── PER (주가수익비율) = 종가 / EPS ──────────────────────────
        Double per = (eps != null && eps != 0) ? round(closePrice / eps) : null;

        // ── PBR (주가순자산비율) = 종가 / BPS ────────────────────────
        Double pbr = (bps != null && bps != 0) ? round(closePrice / bps) : null;

        // ── ROE (자기자본이익률) = 당기순이익 / 자본총계 × 100 ───────
        Double roe = (equity != 0) ? round((double) netIncome / equity * 100) : null;

        // ── 부채비율 = 부채총계 / 자본총계 × 100 ────────────────────
        Double debtRatio = (equity != 0) ? round((double) liabilities / equity * 100) : null;

        // ── 영업이익률 = 영업이익 / 매출액 × 100 ────────────────────
        Double operatingProfitMargin = (revenue != 0) ? round((double) operatingProfit / revenue * 100) : null;

        // ── 배당수익률 ────────────────────────────────────────────────
        // Dividend 테이블에서 해당 종목 + 연도 + 보통주 기준으로 조회
        Optional<Dividend> dividendOpt = dividendRepository
                .findByIdStockCodeAndIdYearAndIdStockType(
                        company.getStockCode(), year, Dividend.StockType.COMMON);

        // 방법 1: Dividend 테이블에 저장된 배당수익률 직접 사용
        Double dividendYieldFromTable = dividendOpt
                .map(d -> round(d.getDividendYield()))  // 이미 % 단위로 저장된 값
                .orElse(null);

        // 방법 2: 주당배당금으로 직접 계산 = 주당배당금 / 종가 × 100
        Double dividendYieldCalc = dividendOpt
                .filter(d -> d.getDividendPerShare() != null && closePrice != 0)
                .map(d -> round(d.getDividendPerShare() / closePrice * 100))
                .orElse(null);

        // 최종 사용: 직접 계산값 우선, 없으면 테이블 저장값 사용
        Double dividendYield = (dividendYieldCalc != null) ? dividendYieldCalc : dividendYieldFromTable;

        return FinancialIndicator.builder()
                .corpCode(company.getCorpCode())
                .stockCode(company.getStockCode())
                .year(year)
                .eps(eps != null ? round(eps) : null)           // 주당순이익
                .bps(bps != null ? round(bps) : null)           // 주당순자산
                .per(per)                                        // 주가수익비율
                .pbr(pbr)                                        // 주가순자산비율
                .roe(roe)                                        // 자기자본이익률 (%)
                .debtRatio(debtRatio)                            // 부채비율 (%)
                .operatingProfitMargin(operatingProfitMargin)    // 영업이익률 (%)
                .dividendYield(dividendYield)                    // 배당수익률 (%)
                .marketCap(marketCap)                            // 시가총액
                .build();
    }

    /**
     * 소수점 둘째자리 반올림
     */
    private Double round(Double value) {
        if (value == null) return null;
        return Math.round(value * 100.0) / 100.0; // 100 곱해서 반올림 후 다시 나누기
    }

    /**
     * 0 나누기 방지 유틸
     */
    private Double safeDiv(long numerator, long denominator) {
        if (denominator == 0) return null; // 분모 0이면 null 반환
        return (double) numerator / denominator;
    }
}