package com.example.demo.Service;

import com.example.demo.Entity.Company;
import com.example.demo.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class DartCompanyCollector {

    // DB 저장용 Repository
    private final CompanyRepository companyRepository;

    // application.yml에 저장한 DART API KEY
    @Value("${dart.api.key}")
    private String apiKey;

    @Transactional
    public void collectCompanies() {

        try {

            // DART 기업목록 API 호출 URL 생성
            String url =
                    "https://opendart.fss.or.kr/api/corpCode.xml?crtfc_key="
                            + apiKey;

            // HTTP 요청 객체
            RestTemplate restTemplate = new RestTemplate();

            // ZIP 파일 다운로드
            byte[] zipData =
                    restTemplate.getForObject(url, byte[].class);

            if (zipData == null) {
                throw new RuntimeException("DART 응답 없음");
            }

            // ZIP 압축 해제
            ZipInputStream zis =
                    new ZipInputStream(
                            new ByteArrayInputStream(zipData)
                    );

            // ZIP 내부 첫 번째 파일(CORPCODE.xml) 읽기
            zis.getNextEntry();

            // XML 파서 생성
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            // XML 문서 읽기
            Document document =
                    builder.parse(zis);

            // 모든 <list> 태그 조회
            NodeList nodeList =
                    document.getElementsByTagName("list");

            List<Company> companies =
                    new ArrayList<>();

            // 기업 수만큼 반복
            for (int i = 0; i < nodeList.getLength(); i++) {

                Element element =
                        (Element) nodeList.item(i);

                // 기업고유번호
                String corpCode =
                        element.getElementsByTagName("corp_code")
                                .item(0)
                                .getTextContent()
                                .trim();

                // 회사명
                String corpName =
                        element.getElementsByTagName("corp_name")
                                .item(0)
                                .getTextContent()
                                .trim();

                // 종목코드
                String stockCode =
                        element.getElementsByTagName("stock_code")
                                .item(0)
                                .getTextContent()
                                .trim();

                // 종목코드가 없으면 비상장사이므로 제외
                if (stockCode.isBlank()) {
                    continue;
                }

                Company company = new Company();

                company.setStockCode(stockCode);
                company.setCorpCode(corpCode);
                company.setCorpName(corpName);

                // 시장구분은 나중에 KRX 데이터로 업데이트 예정
                company.setMarket("UNKNOWN");

                company.setListed(true);

                companies.add(company);
            }

            // 기존 데이터 삭제 후 최신 데이터 저장
            companyRepository.deleteAllInBatch();

            companyRepository.saveAll(companies);

            log.info("기업정보 저장 완료 : {}건", companies.size());

        } catch (Exception e) {

            log.error("기업정보 수집 실패", e);

            throw new RuntimeException(e);
        }
    }
}