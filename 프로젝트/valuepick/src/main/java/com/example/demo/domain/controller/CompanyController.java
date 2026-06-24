package com.example.demo.domain.controller;

import com.example.demo.domain.service.DartCompanyCollector;
import com.example.demo.domain.service.DartCompanyCollectorV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final DartCompanyCollector collector;
    private final DartCompanyCollectorV2 collectorV2;

    // DART에서 전체 상장 기업 목록 수집 후 Company 테이블에 저장
    // 기존: DartStockCollector(발행주식수 수집)는 lstgStCnt(상장주식수)로 대체되어 제거됨
    @GetMapping("/company/load")
    public String load() {
        collector.collectCompanies();
        return "완료";
    }

    @GetMapping("/company/load2")
    public String load2() {
        collectorV2.collectCompanies();
        return "완료";
    }
}
