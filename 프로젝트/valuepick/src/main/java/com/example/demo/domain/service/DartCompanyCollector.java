package com.example.demo.domain.service;

import com.example.demo.domain.entity.Company;
import com.example.demo.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class DartCompanyCollector {

    private final CompanyRepository companyRepository;
    private final RestTemplate restTemplate;

    @Value("${dart.api.key}")
    private String dartApiKey;

    @Value("${stock.api.key}")
    private String stockApiKey;

    private static final String KRX_LISTED_URL = "https://apis.data.go.kr/1160100/service/GetKrxListedInfoService/getItemInfo";

    @Async("dartExecutor")
    public void collectCompanies(String basDt) {

        try {

            // 1단계: KRX상장종목정보 API로 현재 상장된 종목 정보 수집 (KOSPI + KOSDAQ)
            Map<String, KrxStockInfo> krxStockMap = collectKrxStockInfo(basDt);
            log.info("KRX 상장 종목 수집 완료: {}건", krxStockMap.size());

            // 2단계: corpCode.xml에서 KRX 종목과 매핑되는 stockCode→corpCode 맵 추출
            Map<String, String> stockToCorpMap = collectCorpCodeMap(krxStockMap.keySet());
            log.info("DART corpCode 매핑 완료: {}건", stockToCorpMap.size());

            // 기존 데이터 전체 삭제
            companyRepository.deleteAllInBatch();

            int savedCount = 0;

            // 3단계: KRX 정보 + corpCode 합쳐서 Company 저장
            for (Map.Entry<String, String> entry : stockToCorpMap.entrySet()) {

                String stockCode = entry.getKey();
                String corpCode = entry.getValue();
                KrxStockInfo krxInfo = krxStockMap.get(stockCode);

                if (krxInfo == null) continue;

                try {
                    Company company = Company.builder()
                            .stockCode(stockCode)
                            .corpCode(corpCode)
                            .corpName(krxInfo.corpName())
                            .corpCls(krxInfo.corpCls())
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();

                    companyRepository.save(company);
                    savedCount++;
                    log.info("기업정보 저장 완료: {} {} {} (total={})", krxInfo.corpName(), stockCode, krxInfo.corpCls(), savedCount);

                } catch (Exception e) {
                    log.error("기업 처리 실패: {}", stockCode, e);
                }
            }

            log.info("전체 기업정보 저장 완료: {}건", savedCount);

        } catch (Exception e) {
            log.error("기업정보 수집 실패", e);
            throw new RuntimeException(e);
        }
    }

    // KRX상장종목정보 API로 전체 종목 수집 후 mrktCtg로 직접 분류
    private Map<String, KrxStockInfo> collectKrxStockInfo(String basDt) {

        Map<String, KrxStockInfo> stockMap = new HashMap<>();

        String url = UriComponentsBuilder.fromHttpUrl(KRX_LISTED_URL)
                .queryParam("serviceKey", stockApiKey)
                .queryParam("numOfRows", 4000) // 전체 종목 한 번에 수신
                .queryParam("pageNo", 1)
                .queryParam("resultType", "json")
                .queryParam("basDt", basDt)
                .build(false)
                .toUriString();

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            if (response == null) {
                log.warn("KRX 상장종목 API 응답 없음");
                return stockMap;
            }

            Map<String, Object> responseBody = (Map<String, Object>) response.get("response");
            Map<String, Object> body = (Map<String, Object>) responseBody.get("body");
            Map<String, Object> items = (Map<String, Object>) body.get("items");
            List<Map<String, Object>> itemList = (List<Map<String, Object>>) items.get("item");

            for (Map<String, Object> item : itemList) {
                String srtnCd = ((String) item.get("srtnCd")).trim().replaceAll("^A", ""); // A 접두사 제거
                String itmsNm = ((String) item.get("itmsNm")).trim(); // 종목명
                String mrktCtgValue = ((String) item.get("mrktCtg")).trim(); // 실제 시장구분

                // KOSPI, KOSDAQ만 저장 (KONEX, 기타 제외)
                if (!"KOSPI".equals(mrktCtgValue) && !"KOSDAQ".equals(mrktCtgValue)) continue;

                // KOSPI → Y, KOSDAQ → K
                String corpCls = "KOSPI".equals(mrktCtgValue) ? "Y" : "K";

                if (!srtnCd.isBlank()) {
                    stockMap.put(srtnCd, new KrxStockInfo(itmsNm, corpCls));
                }
            }

            log.info("KRX 전체 종목 수집 완료: {}건", stockMap.size());

        } catch (Exception e) {
            log.error("KRX 상장종목 수집 실패", e);
        }

        return stockMap;
    }

    // corpCode.xml에서 listedStockCodes에 있는 종목만 stockCode→corpCode 맵으로 추출
    private Map<String, String> collectCorpCodeMap(Set<String> listedStockCodes) throws Exception {

        String url = "https://opendart.fss.or.kr/api/corpCode.xml?crtfc_key=" + dartApiKey;
        byte[] zipData = restTemplate.getForObject(url, byte[].class);

        if (zipData == null) throw new RuntimeException("DART 응답 없음");

        ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipData));
        zis.getNextEntry();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(zis);

        NodeList nodeList = document.getElementsByTagName("list");
        Map<String, String> stockToCorpMap = new HashMap<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String stockCode = element.getElementsByTagName("stock_code")
                    .item(0).getTextContent().trim();

            if (stockCode.isBlank() || !listedStockCodes.contains(stockCode)) continue;

            String corpCode = element.getElementsByTagName("corp_code")
                    .item(0).getTextContent().trim();

            stockToCorpMap.put(stockCode, corpCode);
        }

        return stockToCorpMap;
    }

    // KRX 종목 정보 담는 레코드
    private record KrxStockInfo(String corpName, String corpCls) {}
}