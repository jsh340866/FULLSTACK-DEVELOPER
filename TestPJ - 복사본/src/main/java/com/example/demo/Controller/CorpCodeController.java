package com.example.demo.Controller;

import com.example.demo.Service.CorpCodeImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CorpCodeController {

    private final CorpCodeImportService corpCodeImportService;

    @GetMapping("/corp/import")
    public String importCorpCode() throws Exception {

        corpCodeImportService.importCorpCode();

        return "OPEN DART stock_code / corp_code 매핑 저장 완료";
    }
}