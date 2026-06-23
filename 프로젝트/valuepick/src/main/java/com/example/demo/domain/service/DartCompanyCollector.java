package com.example.demo.domain.service;

import com.example.demo.domain.entity.Company;
import com.example.demo.domain.repository.CompanyRepository;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class DartCompanyCollector {

    private final CompanyRepository companyRepository;
    private final RestTemplate restTemplate; // 추가

    @Value("${dart.api.key}")
    private String apiKey;

    @Transactional
    public void collectCompanies() {

        try {

            // DART 기업목록 ZIP 파일 다운로드 URL
            String url = "https://opendart.fss.or.kr/api/corpCode.xml?crtfc_key=" + apiKey;


            // ZIP 파일 바이트 배열로 다운로드
            byte[] zipData = restTemplate.getForObject(url, byte[].class);

            if (zipData == null) {
                throw new RuntimeException("DART 응답 없음");
            }

            // ZIP 압축 해제 후 내부 XML 파일 스트림으로 읽기
            ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipData));
            zis.getNextEntry(); // ZIP 내부의 첫 번째 파일(CORPCODE.xml) 진입

            // XML 파서로 DOM 문서 객체 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(zis);

            // XML의 모든 <list> 태그 추출
            NodeList nodeList = document.getElementsByTagName("list");

            List<Company> companies = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {

                Element element = (Element) nodeList.item(i);

                // 기업고유번호 추출
                String corpCode = element.getElementsByTagName("corp_code")
                        .item(0).getTextContent().trim();

                // 회사명 추출
                String corpName = element.getElementsByTagName("corp_name")
                        .item(0).getTextContent().trim();

                // 종목코드 추출
                String stockCode = element.getElementsByTagName("stock_code")
                        .item(0).getTextContent().trim();

                // 종목코드가 없으면 비상장사이므로 제외
                if (stockCode.isBlank()) continue;

                // 새 Company 엔티티는 Builder 방식 사용 (setter 없음)
                // corpCls(시장구분)는 DART API에서 제공하지 않으므로 null로 저장
                Company company = Company.builder()
                        .stockCode(stockCode)
                        .corpCode(corpCode)
                        .corpName(corpName)
                        .corpCls(null) // 시장구분은 별도 업데이트 필요
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build();

                companies.add(company);
            }

            // 기존 데이터 전체 삭제 후 최신 데이터로 교체
            companyRepository.deleteAllInBatch();
            companyRepository.saveAll(companies);

            log.info("기업정보 저장 완료: {}건", companies.size());

        } catch (Exception e) {
            log.error("기업정보 수집 실패", e);
            throw new RuntimeException(e);
        }
    }
}
