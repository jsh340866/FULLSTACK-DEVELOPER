package com.example.demo.Parser;

import com.example.demo.Dto.StockPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;

@Component // 스프링에서 자동 주입 가능
@Slf4j
public class StockPriceXmlParser {

    public StockPriceDto parse(String xml) {

        try {
            // XML 파서 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML 문자열 → InputStream 변환
            Document doc = builder.parse(
                    new ByteArrayInputStream(xml.getBytes())
            );

            doc.getDocumentElement().normalize();

            // item 노드 가져오기
            NodeList items = doc.getElementsByTagName("item");


            log.info("ITEM SIZE = {}", items.getLength());

            if (items.getLength() == 0) return null;

            Element item = (Element) items.item(0);

            // DTO 생성
            StockPriceDto dto = new StockPriceDto();

            // =========================
            // 📌 핵심 매핑 (Entity 기준 정렬)
            // =========================

            dto.setStockCode(get(item, "srtnCd")); // 종목코드
            dto.setTradeDate(get(item, "basDt"));  // 거래일

            dto.setOpenPrice(parseLong(get(item, "mkp")));   // 시가
            dto.setClosePrice(parseLong(get(item, "clpr")));  // 종가
            dto.setHighPrice(parseLong(get(item, "hipr")));   // 고가
            dto.setLowPrice(parseLong(get(item, "lopr")));    // 저가

            dto.setVolume(parseLong(get(item, "trqu")));      // 거래량
            dto.setAmount(parseLong(get(item, "trPrc")));     // 거래대금 (API 기준)

            dto.setChangePrice(parseLong(get(item, "vs")));   // 등락폭
            dto.setChangeRate(parseDouble(get(item, "fltRt"))); // 등락률

            return dto;

        } catch (Exception e) {
            throw new RuntimeException("StockPrice XML 파싱 실패", e);
        }
    }

    /**
     * XML 태그 값 추출
     */
    private String get(Element item, String tag) {

        NodeList list = item.getElementsByTagName(tag);

        if (list.getLength() == 0) return null;

        return list.item(0).getTextContent();
    }

    /**
     * Long 변환
     */
    private Long parseLong(String value) {
        if (value == null || value.isEmpty()) return 0L;
        return Long.parseLong(value.replace(",", "").trim());

    }

    /**
     * Double 변환 (등락률용)
     */
    private Double parseDouble(String value) {
        if (value == null || value.isEmpty()) return 0.0;
        return Double.parseDouble(value);
    }

}