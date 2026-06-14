package com.example.demo.Controller;

import com.example.demo.Service.DartCompanyCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final DartCompanyCollector collector;

    @GetMapping("/company/load")
    public String load() {

        collector.collectCompanies();

        return "완료";
    }
}