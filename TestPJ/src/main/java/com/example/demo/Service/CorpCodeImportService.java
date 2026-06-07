package com.example.demo.Service;

import com.example.demo.Domain.Common.Dtos.CorpCodeItem;
import com.example.demo.Domain.Common.Dtos.CorpCodeResult;
import com.example.demo.Domain.Common.Entity.Company;
import com.example.demo.Domain.Common.Repository.CompanyRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
public class CorpCodeImportService {

    @Value("${dart.api.key}")
    private String apiKey;

    @Value("${dart.api.url}")
    private String apiUrl;

    private final CompanyRepository companyRepository;

    @Transactional
    public void importCorpCode() throws Exception {

        String url = apiUrl + "/corpCode.xml?crtfc_key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        byte[] zipData = restTemplate.getForObject(url, byte[].class);

        if (zipData == null || zipData.length == 0) {
            throw new RuntimeException("OPEN DART corpCode 응답이 비어 있습니다.");
        }

        XmlMapper xmlMapper = new XmlMapper();
        CorpCodeResult result;

        try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipData))) {
            ZipEntry entry;
            result = null;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xml")) {
                    result = xmlMapper.readValue(zis, CorpCodeResult.class);
                    break;
                }
            }
        }

        if (result == null || result.getList() == null) {
            throw new RuntimeException("OPEN DART corpCode XML 파싱에 실패했습니다.");
        }

        List<CorpCodeItem> list = result.getList();
        System.out.println("OPEN DART 전체 기업 수: " + list.size());

        int saveCount = 0;

        for (CorpCodeItem item : list) {

            String stockCode = item.getStockCode();
            if (stockCode == null || stockCode.isBlank()) {
                continue;
            }

            stockCode = stockCode.trim();

            Company company = companyRepository.findByStockCode(stockCode)
                    .orElse(Company.builder().stockCode(stockCode).build());

            company.setCorpCode(item.getCorpCode());
            company.setCorpName(item.getCorpName());
            company.setListed(true);

            companyRepository.save(company);
            saveCount++;
        }

        System.out.println("OPEN DART stock_code 매핑 저장 완료: " + saveCount + "건");
    }
}
