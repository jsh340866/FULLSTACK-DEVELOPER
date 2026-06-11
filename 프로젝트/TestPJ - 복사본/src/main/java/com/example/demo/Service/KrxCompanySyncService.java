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

    private final CompanyRepository companyRepository;
    private final StockPriceRepository stockPriceRepository;

    @Transactional
    public void sync() {

        try {

            int pageNo = 1;
            int numOfRows = 1000;
            int savedCount = 0;

            RestTemplate restTemplate = new RestTemplate();

            while (true) {

                String url = apiUrl
                        + "?serviceKey=" + apiKey
                        + "&numOfRows=" + numOfRows
                        + "&pageNo=" + pageNo;

                String xml = restTemplate.getForObject(url, String.class);

                Document doc = DocumentBuilderFactory.newInstance()
                        .newDocumentBuilder()
                        .parse(new ByteArrayInputStream(xml.getBytes()));

                NodeList items = doc.getElementsByTagName("item");

                if(pageNo == 10) {
                    break;
                }

                if (items.getLength() == 0 ) {
                    break;
                }

                for (int i = 0; i < items.getLength(); i++) {

                    Element item = (Element) items.item(i);

                    String stockCode = get(item, "srtnCd");
                    String basDt = get(item, "basDt");

                    if (stockCode == null || stockCode.isBlank() || basDt == null || basDt.isBlank()) {
                        continue;
                    }

                    StockPrice price = stockPriceRepository
                            .findByStockCodeAndBasDt(stockCode, basDt)
                            .orElse(StockPrice.builder()
                                    .stockCode(stockCode)
                                    .basDt(basDt)
                                    .build());

                    price.setClpr(parseLong(get(item, "clpr")));
                    price.setMkp(parseLong(get(item, "mkp")));
                    price.setHipr(parseLong(get(item, "hipr")));
                    price.setLopr(parseLong(get(item, "lopr")));
                    price.setTrqu(parseLong(get(item, "trqu")));

                    stockPriceRepository.save(price);

                    Company company = companyRepository.findByStockCode(stockCode)
                            .orElse(new Company());

                    company.setStockCode(stockCode);
                    company.setCorpName(get(item, "itmsNm"));
                    company.setMarket(get(item, "mrktCtg"));
                    company.setListed(true);

                    companyRepository.save(company);
                    savedCount++;
                }

                pageNo++;
            }

            System.out.println("공공데이터 주가 저장 완료: " + savedCount + "건");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
