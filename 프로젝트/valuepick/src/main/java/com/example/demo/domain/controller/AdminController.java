package com.example.demo.domain.controller;

import com.example.demo.domain.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// EC2 최초 배포 시 전체 데이터 파이프라인을 수동으로 트리거하기 위한 컨트롤러
// 실행 순서: company -> financial/dividend -> exchange/market -> stock -> indicator -> top100
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin/init")
public class AdminController {

    private final DartCompanyCollector dartCompanyCollector;
    private final DartFinancialCollector dartFinancialCollector;
    private final DividendCollector dividendCollector;
    private final StockPriceCollector stockPriceCollector;
    private final ExchangeRateApiService exchangeRateApiService;
    private final MarketIndexService marketIndexService;
    private final FinancialIndicatorService financialIndicatorService;
    private final Top100Service top100Service;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    // 직전 영업일 - 월요일이면 3일 전(금요일), 일요일이면 2일 전(금요일), 그 외엔 1일 전
    // 스케줄러들(MON-FRI 실행 전제)과 달리 이 컨트롤러는 요일 제한 없이 아무 때나 호출되므로 일요일도 별도 처리
    private LocalDate previousBusinessDay() {
        LocalDate today = LocalDate.now();
        return switch (today.getDayOfWeek()) {
            case MONDAY -> today.minusDays(3);
            case SUNDAY -> today.minusDays(2);
            default -> today.minusDays(1);
        };
    }

    // 사업보고서는 매년 4월 1일에 전년도분이 수집되므로, 그 전엔 재작년(-2) 데이터가, 그 후엔 작년(-1) 데이터가 최신 재무제표임
    // (IndicatorScheduler와 동일한 계산 방식)
    private int activeYear() {
        LocalDate today = LocalDate.now();
        LocalDate collectionDate = LocalDate.of(today.getYear(), 4, 1);
        return today.isBefore(collectionDate) ? today.getYear() - 2 : today.getYear() - 1;
    }

    // 기업정보 수집 - basDt(yyyyMMdd) 직접 입력
    @GetMapping("/company")
    public ResponseEntity<String> collectCompany(@RequestParam String basDt) {
        log.info("[AdminController] 기업정보 수집 요청 - basDt={}", basDt);
        dartCompanyCollector.collectCompanies(basDt);
        return ResponseEntity.ok("기업정보 수집 시작 (비동기) - basDt=" + basDt);
    }

    // 재무제표 수집 - year, reportCode 직접 입력 (reportCode 기본값 11011 사업보고서)
    @GetMapping("/financial")
    public ResponseEntity<String> collectFinancial(
            @RequestParam String year,
            @RequestParam(defaultValue = "11011") String reportCode
    ) {
        log.info("[AdminController] 재무제표 수집 요청 - year={}, reportCode={}", year, reportCode);
        dartFinancialCollector.collect(year, reportCode);
        return ResponseEntity.ok("재무제표 수집 시작 (비동기) - year=" + year + ", reportCode=" + reportCode);
    }

    // 배당금 수집 - year, reportCode 직접 입력 (reportCode 기본값 11011 사업보고서)
    @GetMapping("/dividend")
    public ResponseEntity<String> collectDividend(
            @RequestParam String year,
            @RequestParam(defaultValue = "11011") String reportCode
    ) {
        log.info("[AdminController] 배당금 수집 요청 - year={}, reportCode={}", year, reportCode);
        dividendCollector.collect(year, reportCode);
        return ResponseEntity.ok("배당금 수집 시작 (비동기) - year=" + year + ", reportCode=" + reportCode);
    }

    // 주가 수집 - 직전 영업일 기준 자동 실행
    @GetMapping("/stock")
    public ResponseEntity<String> collectStock() {
        LocalDate targetDate = previousBusinessDay();
        log.info("[AdminController] 주가 수집 요청 - date={}", targetDate);
        stockPriceCollector.collect(targetDate, targetDate);
        return ResponseEntity.ok("주가 수집 완료 - date=" + targetDate);
    }

    // 주가 수집 - 특정 날짜(yyyyMMdd) 지정 실행
    @GetMapping("/stock/{date}")
    public ResponseEntity<String> collectStock(@PathVariable String date) {
        LocalDate targetDate = LocalDate.parse(date, DATE_FORMAT);
        log.info("[AdminController] 주가 수집 요청(지정일) - date={}", targetDate);
        stockPriceCollector.collect(targetDate, targetDate);
        return ResponseEntity.ok("주가 수집 완료 - date=" + targetDate);
    }

    // 환율 수집 - 직전 영업일 기준 자동 실행
    @GetMapping("/exchange")
    public ResponseEntity<String> collectExchange() {
        LocalDate targetDate = previousBusinessDay();
        log.info("[AdminController] 환율 수집 요청 - date={}", targetDate);
        exchangeRateApiService.fetchAndSaveExchangeRates(targetDate.format(DATE_FORMAT));
        return ResponseEntity.ok("환율 수집 완료 - date=" + targetDate);
    }

    // 코스피 지수 수집 - 직전 영업일 기준 자동 실행
    @GetMapping("/market")
    public ResponseEntity<String> collectMarket() {
        LocalDate targetDate = previousBusinessDay();
        log.info("[AdminController] 코스피 지수 수집 요청 - date={}", targetDate);
        marketIndexService.fetchAndSave(targetDate.format(DATE_FORMAT));
        return ResponseEntity.ok("코스피 지수 수집 완료 - date=" + targetDate);
    }

    // 투자지표 계산 - 최신 수집된 사업보고서(11011) 연도 기준 자동 실행
    @GetMapping("/indicator")
    public ResponseEntity<String> calculateIndicator() {
        String year = String.valueOf(activeYear());
        log.info("[AdminController] 투자지표 계산 요청 - year={}", year);
        financialIndicatorService.calculateAll(year, "11011");
        return ResponseEntity.ok("투자지표 계산 완료 - year=" + year);
    }

    // TOP100 스코어 계산
    @GetMapping("/top100")
    public ResponseEntity<String> calculateTop100() {
        log.info("[AdminController] TOP100 스코어 계산 요청");
        top100Service.calculateAndSave();
        return ResponseEntity.ok("TOP100 스코어 계산 완료");
    }
}
