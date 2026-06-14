package com.example.demo.Service;

import com.example.demo.Dto.StockPriceDto;
import com.example.demo.Entity.StockPrice;
import com.example.demo.Parser.StockPriceXmlParser;
import com.example.demo.Repository.CompanyRepository;
import com.example.demo.Repository.StockPriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockPriceCollector {

    // Company에서 stockCode 목록 조회 (전체 종목 기준 데이터)
    private final CompanyRepository companyRepository;

    // StockPrice 저장 (주가 데이터 저장)
    private final StockPriceRepository stockPriceRepository;

    // 공공데이터 API 호출용
    private final RestTemplate restTemplate;

    // XML → DTO 변환 파서
    private final StockPriceXmlParser stockPriceXmlParser;

    @Value("${stock.api.base-url}")
    private String baseUrl;

    @Value("${stock.api.key}")
    private String apiKey;

    /**
     * 전체 종목 주가 수집 시작
     * (Company에 있는 모든 stockCode 기준)
     */
    public void collect(LocalDate startDate, LocalDate endDate) {

        // 전체 종목 코드 조회
        List<String> stockCodes = companyRepository.findAllStockCodes();

        log.info("총 종목 수: {}", stockCodes.size());

        // 종목별 수집 루프
        for (String stockCode : stockCodes) {

            log.info("종목 시작: {}", stockCode);

            try {
                // 해당 종목 기간별 수집
                collectByDateRange(stockCode, startDate, endDate);

            } catch (Exception e) {
                log.error("종목 전체 실패: {}", stockCode, e);
            }
        }
    }

    /**
     * 특정 종목의 기간별 주가 수집
     */
    private void collectByDateRange(String stockCode,
                                    LocalDate startDate,
                                    LocalDate endDate) {

        // 날짜 하루씩 증가하면서 API 호출
        for (LocalDate date = startDate;
             !date.isAfter(endDate);
             date = date.plusDays(1)) {

            try {

                log.info("수집: {} {}", stockCode, date);

                // 공공데이터 API 호출 (XML 반환)
                String xml = requestApi(stockCode, date);

                // XML → DTO 변환
                StockPriceDto dto = stockPriceXmlParser.parse(xml);

                if (dto == null) {
                    log.warn("데이터 없음 SKIP: {} {}", stockCode, date);
                    continue;
                }

                // DTO → Entity 변환 후 저장
                StockPrice entity = mapToEntity(dto);

                stockPriceRepository.save(entity);

                log.info("저장 완료: {} {}", stockCode, date);

                // API 호출 제한 방지
                Thread.sleep(50);

            } catch (Exception e) {
                log.error("날짜 수집 실패: {} {}", stockCode, date, e);
            }
        }
    }

    /**
     * 공공데이터 API 호출 (XML 반환)
     */
    private String requestApi(String stockCode, LocalDate date) {

        String url = buildUrl(stockCode, date);

        return restTemplate.getForObject(url, String.class);
    }

    /**
     * API URL 생성
     */
    private String buildUrl(String stockCode, LocalDate date) {

        return UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .queryParam("serviceKey", apiKey)
                .queryParam("numOfRows", 1)
                .queryParam("pageNo", 1)
                .queryParam("likeSrtnCd", stockCode)
                .queryParam("basDt", date.format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .build(true)
                .toUriString();
    }

    /**
     * DTO → Entity 변환
     */
    private StockPrice mapToEntity(StockPriceDto dto) {

        return StockPrice.builder()
                .stockCode(dto.getStockCode())
                .tradeDate(LocalDate.parse(dto.getTradeDate(),
                        DateTimeFormatter.ofPattern("yyyyMMdd")))
                .openPrice(dto.getOpenPrice())
                .closePrice(dto.getClosePrice())
                .highPrice(dto.getHighPrice())
                .lowPrice(dto.getLowPrice())
                .volume(dto.getVolume())
                .amount(dto.getAmount())
                .changePrice(dto.getChangePrice())
                .changeRate(dto.getChangeRate())
                .build();
    }
}