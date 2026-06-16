package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    // 📌 기업 식별 정보
    private String corpCode;   // DART 기업 코드
    private String stockCode;  // 주식 코드

    // 📌 기준 연도
    private Integer year;      // 사업연도 (2025 등)

    // 📌 재무 핵심 지표 (투자 분석용)
    private Long assets;           // 자산총계
    private Long liabilities;      // 부채총계
    private Long equity;           // 자본총계

    private Long revenue;          // 매출액
    private Long operatingProfit;  // 영업이익
    private Long thstrm_amount;       // 당기순이익



}
