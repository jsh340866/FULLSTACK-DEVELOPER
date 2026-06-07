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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
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

        String url = apiUrl + "/fnlttSinglAcntAll.json"
                + "?crtfc_key=" + apiKey
                + "&corp_code=" + corpCode
                + "&bsns_year=" + year
                + "&reprt_code=11011"
                + "&fs_div=CFS";

        String response = restTemplate.getForObject(url, String.class);

        DartResponse dto = objectMapper.readValue(response, DartResponse.class);

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

        for (int year = 2020; year <= 2026; year++) {
            fetchAndSave(corpCode, String.valueOf(year));
        }
    }

    // =========================
    // 3. 🚀 전체 기업 + 전체 연도 (방법 3)
    // =========================
    public void fetchAllCompanies() throws Exception {

        List<Company> companies = companyRepository.findAll();

        for (Company company : companies) {

            String corpCode = company.getCorpCode();

            for (int year = 2020; year <= 2026; year++) {

                try {
                    fetchAndSave(corpCode, String.valueOf(year));

                    System.out.println("완료: " + corpCode + " / " + year);

                } catch (Exception e) {
                    System.out.println("실패: " + corpCode + " / " + year);
                }
            }
        }
    }

    // =========================
    // 숫자 변환
    // =========================
    private Long parse(String value) {
        if (value == null) return null;
        return Long.parseLong(value.replace(",", "").trim());
    }
}