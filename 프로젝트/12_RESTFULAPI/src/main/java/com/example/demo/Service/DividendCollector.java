package com.example.demo.Service;

import com.example.demo.Dto.DartItem;
import com.example.demo.Dto.DartResponse;
import com.example.demo.Entity.Company;
import com.example.demo.Entity.Dividend;
import com.example.demo.Repository.CompanyRepository;
import com.example.demo.Repository.DividendRepository;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DividendCollector {

    private final RestTemplate restTemplate;
    private final CompanyRepository companyRepository;
    private final DividendRepository dividendRepository;

    @Value("${dart.api.key}")
    private String apiKey;

    private static final int SLEEP_MS = 100;
    private static final int RETRY_COUNT = 1;

    /**
     * 전체 회사 배당 데이터 수집
     */
    public void collect(String year, String reportCode) {

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

                    DartResponse dividendResponse = requestWithRetry(
                            buildDividendUrl(company.getCorpCode(), year, reportCode));

                    log.info("배당 응답 status: {}", dividendResponse != null ? dividendResponse.getStatus() : "null");
                    log.info("배당 리스트: {}", dividendResponse != null ? dividendResponse.getList() : "null");

                    if (dividendResponse == null || !"000".equals(dividendResponse.getStatus())
                            || dividendResponse.getList() == null) {
                        log.warn("배당 API 실패 또는 데이터 없음: {}", company.getCorpName());
                        continue;
                    }

                    int count = saveDividends(company.getStockCode(),
                            Integer.parseInt(year),
                            dividendResponse.getList());
                    savedCount += count;

                    log.info("배당 저장 완료: {} {}건", company.getCorpName(), count);
                    Thread.sleep(SLEEP_MS);

                } catch (Exception e) {
                    log.error("처리 실패: {}", company.getCorpName(), e);
                }
            }

            if (!companyPage.hasNext()) break;
            page++;
        }

        log.info("Dividend 전체 저장 완료: {}건", savedCount);
    }

    /**
     * 배당 파싱 및 저장 (보통주 / 우선주)
     */
    private int saveDividends(String stockCode, int year, List<DartItem> dividendItems) {

        int count = 0;

        Double commonYield = null, commonPerShare = null;
        String commonStlmDt = null;

        Double preferredYield = null, preferredPerShare = null;
        String preferredStlmDt = null;

        for (DartItem item : dividendItems) {

            String se = item.getSe();
            String stockKnd = item.getStockKnd();

            if ("현금배당수익률(%)".equals(se)) {
                if ("보통주".equals(stockKnd)) {
                    commonYield = parseDouble(item.getThstrm());
                    commonStlmDt = item.getStlmDt();
                } else if ("우선주".equals(stockKnd)) {
                    preferredYield = parseDouble(item.getThstrm());
                    preferredStlmDt = item.getStlmDt();
                }
            }

            if ("주당 현금배당금(원)".equals(se)) {
                if ("보통주".equals(stockKnd)) {
                    commonPerShare = parseDouble(item.getThstrm());
                } else if ("우선주".equals(stockKnd)) {
                    preferredPerShare = parseDouble(item.getThstrm());
                }
            }
        }

        // 보통주 저장
        count += saveDividendIfAbsent(stockCode, year, Dividend.StockType.COMMON,
                commonYield, commonPerShare, commonStlmDt);

        // 우선주 (데이터 있을 때만)
        if (preferredYield != null || preferredPerShare != null) {
            count += saveDividendIfAbsent(stockCode, year, Dividend.StockType.PREFERRED,
                    preferredYield, preferredPerShare, preferredStlmDt);
        }

        return count;
    }

    private int saveDividendIfAbsent(String stockCode, int year,
                                     Dividend.StockType stockType,
                                     Double yield, Double perShare, String stlmDt) {

        Dividend.DividendId id = new Dividend.DividendId(stockCode, year, stockType);

        if (dividendRepository.existsById(id)) {
            log.info("이미 존재, 스킵: {} {} {}", stockCode, year, stockType);
            return 0;
        }

        dividendRepository.save(Dividend.builder()
                .id(id)
                .dividendYield(yield)
                .dividendPerShare(perShare)
                .stlmDt(stlmDt)
                .build());

        return 1;
    }

    private DartResponse requestWithRetry(String url) {

        for (int i = 0; i < RETRY_COUNT; i++) {

            try {
                ResponseEntity<DartResponse> response =
                        restTemplate.getForEntity(url, DartResponse.class);
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

    private String buildDividendUrl(String corpCode, String year, String reportCode) {
        return "https://opendart.fss.or.kr/api/alotMatter.json"
                + "?crtfc_key=" + apiKey
                + "&corp_code=" + corpCode
                + "&bsns_year=" + year
                + "&reprt_code=" + reportCode;
    }

    private Double parseDouble(String value) {
        if (value == null || value.isBlank() || "-".equals(value.trim())) return null;
        return Double.parseDouble(value.replace(",", ""));
    }
}