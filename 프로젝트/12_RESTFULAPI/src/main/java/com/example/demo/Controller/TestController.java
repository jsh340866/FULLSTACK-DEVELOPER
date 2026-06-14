package com.example.demo.Controller;

import com.example.demo.Service.DartCompanyCollector;
import com.example.demo.Service.DartStockCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final DartCompanyCollector collector;
    private final DartStockCollector stockCollector;

    @GetMapping("/company/load")
    public String load() {
        collector.collectCompanies();
        return "완료";
    }

    @GetMapping("/company/stock/{year}")  // 추가
    public String loadStock(@PathVariable String year) {
        stockCollector.collectStockCount(year);
        return "완료";
    }

    @GetMapping("/company/loadAll/{year}")
    public String loadAll(@PathVariable String year) {
        collector.collectCompanies();       // 1. 기업 목록 수집
        stockCollector.collectStockCount(year); // 2. 주식수 수집
        return "완료";
    }


}