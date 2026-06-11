package com.example.demo.Service;

import com.example.demo.Domain.Common.Dtos.DartItem;
import com.example.demo.Domain.Common.Dtos.DartResponse;
import com.example.demo.Domain.Common.Entity.Company;
import com.example.demo.Domain.Common.Entity.Financial;
import com.example.demo.Domain.Common.Repository.CompanyRepository;
import com.example.demo.Domain.Common.Repository.FinancialRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DartFinancialService {

    private final CompanyRepository companyRepository;
    private final FinancialRepository financialRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${dart.api.key}")
    private String apiKey;

    @Value("${dart.api.url}")
    private String apiUrl;

    // =========================
    // 1. 단일 호출 (핵심 로직)
    // =========================
    @Transactional
    public void fetchAndSave(String corpCode, String year) throws Exception {

        if (financialRepository.findByCorpCodeAndBsnsYear(corpCode, year).isPresent()) {
            log.debug("이미 저장됨 - 스킵: {} / {}", corpCode, year);
            return;
        }

        String url = apiUrl + "/fnlttSinglAcntAll.json"
                + "?crtfc_key=" + apiKey
                + "&corp_code=" + corpCode
                + "&bsns_year=" + year
                + "&reprt_code=11011"
                + "&fs_div=CFS";
        log.info(url);
        String response = restTemplate.getForObject(url, String.class);

        DartResponse dto = objectMapper.readValue(response, DartResponse.class);

        if (dto.getList() == null || dto.getList().isEmpty()) {
            log.warn("재무 데이터 없음: {} / {}", corpCode, year);
            return;
        }

        Long netIncome = null;
        Long equity = null;
        Long liability = null;

        for (DartItem item : dto.getList()) {

            String name = item.getAccount_nm();
            Long value = parse(item.getThstrm_amount());

            if ("당기순이익".equals(name)) netIncome = value;
            if ("자본총계".equals(name)) equity = value;
            if ("부채총계".equals(name)) liability = value;
        }

        Double debtRatio = null;
        if (equity != null && equity != 0 && liability != null) {
            debtRatio = (liability.doubleValue() / equity.doubleValue()) * 100;
        }

        Financial financial = Financial.builder()
                .corpCode(corpCode)
                .bsnsYear(year)
                .netIncome(netIncome)
                .equity(equity)
                .liability(liability)
                .debtRatio(debtRatio)
                .build();

        financialRepository.save(financial);
    }

    // =========================
    // 2. 기업 1개 + 여러 연도
    // =========================
    public void fetchByCorpCode(String corpCode) throws Exception {

        for (int year = 2020; year <= 2025; year++) {
            fetchAndSave(corpCode, String.valueOf(year));
        }
    }

    // =========================
    // 3. 필터 기반 배치 실행
    // =========================
    public void fetchFiltered(String market, Integer fromYear, Integer toYear, String stockCode) throws Exception {

        List<Company> companies = resolveCompanies(market, stockCode);
        int startYear = fromYear != null ? fromYear : 2025;
        int endYear = toYear != null ? toYear : startYear;

        log.info("DART 배치 시작 - 기업 {}건, {}~{}", companies.size(), startYear, endYear);

        for (Company company : companies) {
            String corpCode = company.getCorpCode();
            if (corpCode == null || corpCode.isBlank()) {
                continue;
            }

            for (int year = startYear; year <= endYear; year++) {
                try {
                    fetchAndSave(corpCode, String.valueOf(year));
                    log.info("완료: {} / {}", corpCode, year);
                } catch (Exception e) {
                    log.warn("실패: {} / {} - {}", corpCode, year, e.getMessage());
                }
            }
        }
    }

    // =========================
    // 4. 전체 기업 + 전체 연도 (하위 호환)
    // =========================
    public void fetchAllCompanies() throws Exception {
        fetchFiltered(null, 2025, 2025, null);
    }

    private List<Company> resolveCompanies(String market, String stockCode) {
        if (stockCode != null && !stockCode.isBlank()) {
            return companyRepository.findByStockCode(stockCode.trim())
                    .map(List::of)
                    .orElse(List.of());
        }
        if (market != null && !market.isBlank()) {
            return companyRepository.findByMarket(market.trim());
        }
        return companyRepository.findByListedTrue();
    }

    // =========================
    // 숫자 변환
    // =========================
    private Long parse(String value) {
        if (value == null) return null;
        return Long.parseLong(value.replace(",", "").trim());
    }
}