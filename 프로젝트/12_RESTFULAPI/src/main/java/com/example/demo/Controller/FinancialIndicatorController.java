package com.example.demo.Controller;

import com.example.demo.Service.FinancialIndicatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin/indicator")
public class FinancialIndicatorController {

    private final FinancialIndicatorService financialIndicatorService;

    /**
     * 전체 회사 지표 계산 실행
     * GET /api/indicator/calculate?year=2024
     */
    @GetMapping("/calculate/{year}")
    public ResponseEntity<String> calculate(@PathVariable int year) {

        log.info("지표 계산 요청: year={}", year); // 요청 로그

        financialIndicatorService.calculateAll(year); // 계산 서비스 호출

        return ResponseEntity.ok(year + "년 지표 계산 완료"); // 완료 응답
    }
}