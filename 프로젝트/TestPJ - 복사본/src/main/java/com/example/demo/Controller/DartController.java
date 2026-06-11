package com.example.demo.Controller;

import com.example.demo.Service.DartFinancialService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dart")
public class    DartController {

    private final DartFinancialService dartFinancialService;

    // 전체 기업 + 전체 연도 실행
    @GetMapping("/run-all")
    public String runAll() throws Exception {

        dartFinancialService.fetchAllCompanies();



        return "DART 배치 실행 완료";
    }
}
