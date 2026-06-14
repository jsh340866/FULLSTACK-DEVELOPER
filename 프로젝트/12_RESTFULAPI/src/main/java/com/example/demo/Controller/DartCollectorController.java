package com.example.demo.Controller;

import com.example.demo.Service.DartFinancialCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/dart")
public class DartCollectorController {

    private final DartFinancialCollector dartFinancialCollector;

    @GetMapping("/financial/{year}")
    public String collectFinancial(
            @PathVariable String year,
            @RequestParam(defaultValue = "11011") String reportCode
            //11011 → 사업보고서
            //11012 → 반기보고서
            //11013 → 1분기
            //11014 → 3분기
    ) {

        // DART 재무 데이터 수집 실행
        dartFinancialCollector.collect(year, reportCode);

        return "Financial 데이터 수집 완료";
    }
}

