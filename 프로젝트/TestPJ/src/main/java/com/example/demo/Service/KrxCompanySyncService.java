package com.example.demo.Service;

import com.example.demo.Domain.Common.Entity.Company;
import com.example.demo.Domain.Common.Entity.StockPrice;
import com.example.demo.Domain.Common.Repository.CompanyRepository;
import com.example.demo.Domain.Common.Repository.StockPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

@Service
@RequiredArgsConstructor
public class KrxCompanySyncService {

    @Value("${krx.api.key}")
    private String apiKey;

    @Value("${krx.api.url}")
    private String apiUrl;

    @Value("${krx.api.filter.bas-dt:}")
    private String defaultBasDt;

    @Value("${krx.api.filter.mrkt-ctg:}")
    private String defaultMrktCtg;

    @Value("${krx.api.filter.stock-code:}")
    private String defaultStockCode;

    private final CompanyRepository companyRepository;
    private final StockPriceRepository stockPriceRepository;

    @Transactional
    public void sync() {
        sync(null, null, null);
    }

    @Transactional
    public void sync(String basDt, String mrktCtg, String stockCode) {

        try {
            String effectiveBasDt = resolveParam(basDt, defaultBasDt);
            String effectiveMrktCtg = resolveParam(mrktCtg, defaultMrktCtg);
            String effectiveStockCode = resolveParam(stockCode, defaultStockCode);

            int pageNo = 1;
            int numOfRows = 1000;
            int savedCount = 0;
            int skippedCount = 0;

            RestTemplate restTemplate = new RestTemplate();

            while (true) {

                String url = buildUrl(numOfRows, pageNo, effectiveBasDt, effectiveMrktCtg, effectiveStockCode);
                String xml = restTemplate.getForObject(url, String.class);

                Document doc = DocumentBuilderFactory.newInstance()
                        .newDocumentBuilder()
                        .parse(new ByteArrayInputStream(xml.getBytes()));

                NodeList items = doc.getElementsByTagName("item");

                if (items.getLength() == 0) {
                    break;
                }

                for (int i = 0; i < items.getLength(); i++) {

                    Element item = (Element) items.item(i);

                    String itemStockCode = get(item, "srtnCd");
                    String itemBasDt = get(item, "basDt");

                    if (itemStockCode == null || itemStockCode.isBlank()
                            || itemBasDt == null || itemBasDt.isBlank()) {
                        continue;
                    }

                    if (stockPriceRepository.findByStockCodeAndBasDt(itemStockCode, itemBasDt).isPresent()) {
                        skippedCount++;
                        continue;
                    }

                    StockPrice price = StockPrice.builder()
                            .stockCode(itemStockCode)
                            .basDt(itemBasDt)
                            .build();

                    price.setClpr(parseLong(get(item, "clpr")));
                    price.setMkp(parseLong(get(item, "mkp")));
                    price.setHipr(parseLong(get(item, "hipr")));
                    price.setLopr(parseLong(get(item, "lopr")));
                    price.setTrqu(parseLong(get(item, "trqu")));

                    stockPriceRepository.save(price);

                    Company company = companyRepository.findByStockCode(itemStockCode)
                            .orElse(new Company());

                    company.setStockCode(itemStockCode);
                    company.setCorpName(get(item, "itmsNm"));
                    company.setMarket(get(item, "mrktCtg"));
                    company.setListed(true);

                    companyRepository.save(company);
                    savedCount++;
                }

                if (items.getLength() < numOfRows) {
                    break;
                }

                pageNo++;
            }

            System.out.println("공공데이터 주가 저장 완료: " + savedCount + "건, 스킵: " + skippedCount + "건");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String buildUrl(int numOfRows, int pageNo, String basDt, String mrktCtg, String stockCode) {
        StringBuilder url = new StringBuilder(apiUrl)
                .append("?serviceKey=").append(apiKey)
                .append("&numOfRows=").append(numOfRows)
                .append("&pageNo=").append(pageNo);

        if (basDt != null && !basDt.isBlank()) {
            url.append("&basDt=").append(basDt.trim());
        }
        if (mrktCtg != null && !mrktCtg.isBlank()) {
            url.append("&mrktCtg=").append(mrktCtg.trim());
        }
        if (stockCode != null && !stockCode.isBlank()) {
            url.append("&likeSrtnCd=").append(stockCode.trim());
        }

        return url.toString();
    }

    private String resolveParam(String requestValue, String defaultValue) {
        if (requestValue != null && !requestValue.isBlank()) {
            return requestValue.trim();
        }
        if (defaultValue != null && !defaultValue.isBlank()) {
            return defaultValue.trim();
        }
        return null;
    }

    private String get(Element item, String tag) {
        NodeList nl = item.getElementsByTagName(tag);
        return nl.getLength() > 0 ? nl.item(0).getTextContent().trim() : null;
    }

    private Long parseLong(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return Long.parseLong(value.replace(",", "").trim());
    }
}
