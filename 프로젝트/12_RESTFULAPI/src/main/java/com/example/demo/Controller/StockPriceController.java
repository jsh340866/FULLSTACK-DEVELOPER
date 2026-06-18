package com.example.demo.Controller;

import com.example.demo.Service.StockPriceCollector;
import lombok.RequiredArgsConstructor; // 생성자 자동 생성
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // REST API

import java.time.LocalDate; // 날짜 타입
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController // REST 컨트롤러
@RequiredArgsConstructor // final 필드 생성자 자동 주입
@RequestMapping("/admin/stock") // 공통 URL prefix
public class StockPriceController {

    private final StockPriceCollector stockPriceCollector; // 주가 수집 서비스

    /**
     * 기간만 입력하면 전체 종목 자동 수집
     */
    @GetMapping({"/collect/{startDate}", "/collect/{startDate}/{endDate}"})
    public ResponseEntity<Map<String, String>> collect(
            @PathVariable String startDate,
            @PathVariable(required = false) String endDate
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = (endDate == null) ? start : LocalDate.parse(endDate, formatter);

        stockPriceCollector.collect(start, end);   // 즉시 리턴, 백그라운드 실행

        return ResponseEntity.accepted().body(Map.of(
                "status", "started",
                "startDate", start.toString(),
                "endDate", end.toString()
        ));
    }
}