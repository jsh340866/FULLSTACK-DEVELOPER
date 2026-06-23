package com.example.demo.domain.parser;

import com.example.demo.domain.dto.StockPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class StockPriceXmlParser {

    public StockPriceDto parse(String xml) {

        try {
            // XML 파서 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML 문자열 → InputStream 변환 후 DOM 파싱
            Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));
            doc.getDocumentElement().normalize();

            // <item> 노드 추출
            NodeList items = doc.getElementsByTagName("item");

            log.info("ITEM SIZE = {}", items.getLength());

            // 데이터가 없으면 null 반환 (거래 없는 날 등)
            if (items.getLength() == 0) return null;

            Element item = (Element) items.item(0);

            // API XML 태그명은 그대로 사용하되, DTO 필드명을 새 엔티티 기준으로 변경
            // 기존: dto.setStockCode / dto.setTradeDate / dto.setClosePrice ...
            // 변경: srtnCd / basDt / clpr / mkp / fltRt / lstgStCnt / mrktTotAmt

            // "basDt" XML 태그값 "20240101" → LocalDate 변환
            String basDtStr = get(item, "basDt");
            LocalDate basDt = (basDtStr != null && !basDtStr.isBlank())
                    ? LocalDate.parse(basDtStr, DateTimeFormatter.ofPattern("yyyyMMdd"))
                    : null;

            return StockPriceDto.builder()
                    .srtnCd(get(item, "srtnCd"))                    // 종목코드
                    .basDt(basDt)                                   // 기준일 (String → LocalDate 변환)
                    .clpr(parseLong(get(item, "clpr")))             // 종가
                    .mkp(parseLong(get(item, "mkp")))               // 시가
                    .fltRt(parseDouble(get(item, "fltRt")))         // 등락률
                    .lstgStCnt(parseLong(get(item, "lstgStCnt")))   // 상장주식수 (발행주식수 대체)
                    .mrktTotAmt(parseLong(get(item, "mrktTotAmt"))) // 시가총액
                    .createdAt(LocalDateTime.now())                  // 저장 시각
                    .updatedAt(LocalDateTime.now())                  // 수정 시각
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("StockPrice XML 파싱 실패", e);
        }
    }

    // XML 태그 값 추출 유틸
    private String get(Element item, String tag) {
        NodeList list = item.getElementsByTagName(tag);
        if (list.getLength() == 0) return null;
        return list.item(0).getTextContent();
    }

    // 문자열 → Long 변환 (콤마 제거, null/빈값은 null 반환)
    private Long parseLong(String value) {
        if (value == null || value.isBlank()) return null;
        try {
            return Long.parseLong(value.replace(",", "").trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // 문자열 → Double 변환 (등락률용, null/빈값은 null 반환)
    private Double parseDouble(String value) {
        if (value == null || value.isBlank()) return null;
        try {
            return Double.parseDouble(value.replace(",", "").trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
