package com.example.demo.domain.controller;

import com.example.demo.domain.service.DartFinancialCollector;
import com.example.demo.domain.service.DividendCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DartCollectorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DartFinancialCollector dartFinancialCollector;

    @MockBean
    DividendCollector dividendCollector;

    // ──────────────────────────────────────────────
    // /admin/dart/financial/{year}
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("재무 수집 - reportCode 기본값(11011) 사용")
    void collectFinancial_defaultReportCode() throws Exception {
        mockMvc.perform(get("/admin/dart/financial/2023"))
                .andExpect(status().isOk())
                .andExpect(content().string("Financial 데이터 수집 완료"));

        verify(dartFinancialCollector, times(1)).collect("2023", "11011");
    }

    @Test
    @DisplayName("재무 수집 - reportCode 명시적으로 전달(반기보고서)")
    void collectFinancial_customReportCode() throws Exception {
        mockMvc.perform(get("/admin/dart/financial/2023")
                        .param("reportCode", "11012"))
                .andExpect(status().isOk())
                .andExpect(content().string("Financial 데이터 수집 완료"));

        verify(dartFinancialCollector, times(1)).collect("2023", "11012");
    }

    @Test
    @DisplayName("재무 수집 - 서비스 호출 시 예외 발생 → 500 응답")
    void collectFinancial_serviceThrows() throws Exception {
        doThrow(new RuntimeException("API 오류"))
                .when(dartFinancialCollector).collect(anyString(), anyString());

        mockMvc.perform(get("/admin/dart/financial/2023"))
                .andExpect(status().isInternalServerError());
    }

    // ──────────────────────────────────────────────
    // /admin/dart/dividend/{year}
    // ──────────────────────────────────────────────

    @Test
    @DisplayName("배당 수집 - reportCode 기본값(11011) 사용")
    void collectDividend_defaultReportCode() throws Exception {
        mockMvc.perform(get("/admin/dart/dividend/2023"))
                .andExpect(status().isOk())
                .andExpect(content().string("Dividend 데이터 수집 완료"));

        verify(dividendCollector, times(1)).collect("2023", "11011");
    }

    @Test
    @DisplayName("배당 수집 - reportCode 명시적으로 전달(3분기)")
    void collectDividend_customReportCode() throws Exception {
        mockMvc.perform(get("/admin/dart/dividend/2023")
                        .param("reportCode", "11014"))
                .andExpect(status().isOk())
                .andExpect(content().string("Dividend 데이터 수집 완료"));

        verify(dividendCollector, times(1)).collect("2023", "11014");
    }

    @Test
    @DisplayName("배당 수집 - 서비스 호출 시 예외 발생 → 500 응답")
    void collectDividend_serviceThrows() throws Exception {
        doThrow(new RuntimeException("외부 API 타임아웃"))
                .when(dividendCollector).collect(anyString(), anyString());

        mockMvc.perform(get("/admin/dart/dividend/2023"))
                .andExpect(status().isInternalServerError());
    }
}