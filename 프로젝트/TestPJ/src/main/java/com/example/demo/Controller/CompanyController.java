package com.example.demo.Controller;

import com.example.demo.Service.KrxCompanySyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final KrxCompanySyncService krxCompanySyncService;

    @GetMapping("/sync")
    public String sync(
            @RequestParam(required = false) String basDt,
            @RequestParam(required = false) String mrktCtg,
            @RequestParam(required = false) String stockCode
    ) {
        krxCompanySyncService.sync(basDt, mrktCtg, stockCode);
        return "공공데이터 주가 저장 완료 (srtnCd, clpr, mkp, hipr, lopr, trqu, basDt)";
    }
}
