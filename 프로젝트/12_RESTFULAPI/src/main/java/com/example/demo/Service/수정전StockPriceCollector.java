//package com.example.demo.Service;
//
//import com.example.demo.Dto.StockPriceDto;
//import com.example.demo.Entity.StockPrice;
//import com.example.demo.Parser.StockPriceXmlParser;
//import com.example.demo.Repository.CompanyRepository;
//import com.example.demo.Repository.StockPriceRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class 수정전StockPriceCollector {
//
//    // Company에서 stockCode 목록 조회 (전체 종목 기준 데이터)
//    private final CompanyRepository companyRepository;
//
//    // StockPrice 저장 (주가 데이터 저장)
//    private final StockPriceRepository stockPriceRepository;
//
//    // 공공데이터 API 호출용
//    private final RestTemplate restTemplate;
//
//    // XML → DTO 변환 파서
//    private final StockPriceXmlParser stockPriceXmlParser;
//
//    @Value("${stock.api.base-url}")
//    private String baseUrl;
//
//    @Value("${stock.api.key}")
//    private String apiKey;
//
//    /**
//     * 전체 종목 주가 수집 시작
//     * (Company에 있는 모든 stockCode 기준)
//     */
//    /**
//     * 전체 종목 주가 수집 시작
//     * (Company에 있는 모든 stockCode 기준)
//     */
//    public void collect(LocalDate startDate, LocalDate endDate) {
//
//        int savedCount = 0;            // 전체 저장 건수
//        int page = 0;                  // 현재 페이지 번호
//        final int PAGE_SIZE = 100;     // 한 번에 조회할 종목 수
//
//        while (true) {
//
//            Pageable pageable = PageRequest.of(page, PAGE_SIZE);                        // 현재 페이지 번호와 사이즈로 Pageable 생성
//            Page<String> stockCodePage = companyRepository.findAllStockCodes(pageable); // 100건씩 DB에서 종목코드 조회
//            List<String> stockCodes = stockCodePage.getContent();                       // Page에서 실제 종목코드 리스트 추출
//
//            if (stockCodes.isEmpty()) break; // 조회 결과 없으면 반복 종료
//
//            log.info("페이지 {}: {}건 처리 중", page, stockCodes.size()); // 현재 페이지 진행 상황 로그
//
//            for (String stockCode : stockCodes) { // 조회된 종목코드 하나씩 처리
//
//                log.info("종목 시작: {}", stockCode); // 종목 처리 시작 로그
//
//                try {
//                    savedCount += collectByDateRange(stockCode, startDate, endDate); // 수집 후 저장 건수 누적
//
//                } catch (Exception e) {
//                    log.error("종목 전체 실패: {}", stockCode, e); // 실패 시 에러 로그 후 다음 종목으로 이동
//                }
//            }
//
//            if (!stockCodePage.hasNext()) break; // 마지막 페이지면 반복 종료
//            page++;                              // 다음 페이지로 이동
//        }
//
//        log.info("전체 저장 완료: {}건", savedCount); // 최종 저장 건수 로그
//    }
//
//    /**
//     * 특정 종목의 기간별 주가 수집
//     */
//    private int collectByDateRange(String stockCode,  // void → int 변경
//                                   LocalDate startDate,
//                                   LocalDate endDate) {
//
//        int savedCount = 0; // 해당 종목 저장 건수
//
//        for (LocalDate date = startDate;
//             !date.isAfter(endDate);
//             date = date.plusDays(1)) { // 날짜 하루씩 증가하면서 API 호출
//
//            try {
//
//                log.info("수집: {} {}", stockCode, date);
//
//                String xml = requestApi(stockCode, date); // 공공데이터 API 호출 (XML 반환)
//
//                StockPriceDto dto = stockPriceXmlParser.parse(xml); // XML → DTO 변환
//
//                if (dto == null) {
//                    log.warn("데이터 없음 SKIP: {} {}", stockCode, date); // 데이터 없으면 스킵
//                    continue;
//                }
//
//                StockPrice entity = mapToEntity(dto); // DTO → Entity 변환
//
//                stockPriceRepository.save(entity); // DB 저장
//                savedCount++;                       // 저장 건수 증가
//
//                log.info("저장 완료: {} {}", stockCode, date);
//
//                Thread.sleep(50); // API 호출 제한 방지
//
//            } catch (Exception e) {
//                log.error("날짜 수집 실패: {} {}", stockCode, date, e); // 실패 시 에러 로그 후 다음 날짜로 이동
//            }
//        }
//
//        return savedCount; // 해당 종목 저장 건수 반환
//    }
//
//        /**
//     * 공공데이터 API 호출 (XML 반환)
//     */
//    private String requestApi(String stockCode, LocalDate date) {
//
//        String url = buildUrl(stockCode, date);
//
//        return restTemplate.getForObject(url, String.class);
//    }
//
//
//    /**
//     * API URL 생성
//     */
//    private String buildUrl(String stockCode, LocalDate date) {
//
//        return UriComponentsBuilder
//                .fromHttpUrl(baseUrl)
//                .queryParam("serviceKey", apiKey)
//                .queryParam("numOfRows", 1)
//                .queryParam("pageNo", 1)
//                .queryParam("likeSrtnCd", stockCode)
//                .queryParam("basDt", date.format(DateTimeFormatter.ofPattern("yyyyMMdd")))
//                .build(true)
//                .toUriString();
//    }
//
//    /**
//     * DTO → Entity 변환
//     */
//    private StockPrice mapToEntity(StockPriceDto dto) {
//
//        return StockPrice.builder()
//                .stockCode(dto.getStockCode())
//                .tradeDate(LocalDate.parse(dto.getTradeDate(),
//                        DateTimeFormatter.ofPattern("yyyyMMdd")))
//                .openPrice(dto.getOpenPrice())
//                .closePrice(dto.getClosePrice())
//                .highPrice(dto.getHighPrice())
//                .lowPrice(dto.getLowPrice())
//                .volume(dto.getVolume())
//                .amount(dto.getAmount())
//                .changePrice(dto.getChangePrice())
//                .changeRate(dto.getChangeRate())
//                .mrktCtg(dto.getMrktCtg())
//                .build();
//    }
//}