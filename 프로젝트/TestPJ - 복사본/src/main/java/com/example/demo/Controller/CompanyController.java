package com.example.demo.Controller;

import com.example.demo.Service.KrxCompanySyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final KrxCompanySyncService krxCompanySyncService;

    @GetMapping("/sync")
    public String sync() {
        krxCompanySyncService.sync();
        return "공공데이터 주가 저장 완료 (srtnCd, clpr, mkp, hipr, lopr, trqu, basDt)";
    }
}