package com.example.demo.domain.service;

import com.example.demo.domain.dto.StockPriceDto;
import com.example.demo.domain.entity.Company;
import com.example.demo.domain.repository.CompanyRepository;
import com.example.demo.domain.repository.StockPriceRepository;
import com.example.demo.domain.parser.StockPriceXmlParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
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

    private final CompanyRepository companyRepository;
    private final StockPriceRepository stockPriceRepository;
    private final RestTemplate restTemplate;
    private final StockPriceXmlParser stockPriceXmlParser; // XML → StockPriceDto 변환 파서 주입

    @Value("${stock.api.base-url}")
    private String baseUrl;

    @Value("${stock.api.key}")
    private String apiKey;

    // 비동기 실행 - 전체 종목 주가 수집 (백그라운드 처리)
    @Async("stockExecutor")
    public void collect(LocalDate startDate, LocalDate endDate) {

        int savedCount = 0;
        int page = 0;
        final int PAGE_SIZE = 100;

        while (true) {

            // corpCls 업데이트도 같이 하기 위해 종목코드만이 아닌 Company 객체로 조회
            Pageable pageable = PageRequest.of(page, PAGE_SIZE);
            Page<Company> companyPage = companyRepository.findAll(pageable);
            List<Company> companies = companyPage.getContent();

            if (companies.isEmpty()) break;

            log.info("페이지 {}: {}건 처리 중", page, companies.size());

            // 병렬 스트림으로 종목별 주가 수집 (처리 속도 향상)
            int pageCount = companies.parallelStream()
                    .mapToInt(company -> {
                        try {
                            return collectByDateRange(company, startDate, endDate);
                        } catch (Exception e) {
                            log.error("종목 전체 실패: {}", company.getStockCode(), e);
                            return 0;
                        }
                    })
                    .sum();

            savedCount += pageCount;

            if (!companyPage.hasNext()) break;
            page++;
        }

        log.info("전체 저장 완료: {}건", savedCount);
    }

    // 특정 종목의 날짜 범위별 주가 수집
    private int collectByDateRange(Company company, LocalDate startDate, LocalDate endDate) {

        int savedCount = 0;

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {

            try {

                // 이미 해당 종목 + 날짜 데이터가 있으면 중복 저장 방지
                if (stockPriceRepository.findBySrtnCdAndBasDt(company.getStockCode(), date).isPresent()) {
                    log.info("이미 존재, 스킵: {} {}", company.getStockCode(), date);
                    continue;
                }

                // 공공데이터 API 호출 → XML 문자열 반환
                String xml = requestApi(company.getStockCode(), date);

                // XML → StockPriceDto 변환 (파서 사용)
                StockPriceDto dto = stockPriceXmlParser.parse(xml);

                if (dto == null) {
                    log.warn("데이터 없음 SKIP: {} {}", company.getStockCode(), date);
                    continue;
                }

                // DTO → StockPrice 엔티티 저장
                stockPriceRepository.save(dto.toEntity());
                savedCount++;

                // corpCls가 null이면 파서로 mrktCtg 추출해서 Company에 바로 업데이트
                // StockPriceDto 수정 없이 XML에서 직접 꺼내는 방식
                if (company.getCorpCls() == null) {
                    String mrktCtg = stockPriceXmlParser.parseMrktCtg(xml);
                    if (mrktCtg != null) {
                        String corpCls = mrktCtg.equals("KOSPI") ? "K" : "Q"; // KOSPI→K, KOSDAQ→Q 변환
                        company.updateCorpCls(corpCls);
                        companyRepository.save(company);
                    }
                }

                log.info("저장 완료: {} {}", company.getStockCode(), date);

            } catch (Exception e) {
                log.error("날짜 수집 실패: {} {}", company.getStockCode(), date, e);
            }
        }

        return savedCount;
    }

    // 공공데이터 API 호출 (XML 문자열 반환)
    private String requestApi(String stockCode, LocalDate date) {
        String url = buildUrl(stockCode, date);
        return restTemplate.getForObject(url, String.class);
    }

    // API URL 생성 - 종목코드(likeSrtnCd)와 기준일(basDt) 파라미터 사용
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
}