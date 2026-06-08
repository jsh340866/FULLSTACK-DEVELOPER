package com.example.demo.Controller;

import com.example.demo.Service.DartFinancialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dart")
public class DartController {

    private final DartFinancialService dartFinancialService;

    @GetMapping("/run")
    public String run(
            @RequestParam(required = false) String market,
            @RequestParam(required = false) Integer fromYear,
            @RequestParam(required = false) Integer toYear,
            @RequestParam(required = false) String stockCode
    ) throws Exception {

        dartFinancialService.fetchFiltered(market, fromYear, toYear, stockCode);
        return "DART 배치 실행 완료";
    }

    @GetMapping("/run-all")
    public String runAll() throws Exception {
        dartFinancialService.fetchAllCompanies();
        return "DART 전체 배치 실행 완료";
    }
}
