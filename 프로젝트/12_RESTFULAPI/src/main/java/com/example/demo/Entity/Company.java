package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    private String stockCode;   // 종목코드
    private String corpCode;    // DART 기업코드
    private String corpName;    // 회사명
    private String market;      // KOSPI, KOSDAQ
    private boolean listed;     // 상장여부

    // 📌 재무 기준 (정석 계산용)
    private Long istcTotqy;     // PER / PBR 계산 기준 (전체 주식수)

    // 📌 실전 투자 기준
    private Long distbStockCo;  // 실제 유통 기반 투자 판단
}