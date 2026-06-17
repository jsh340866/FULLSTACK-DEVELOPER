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
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"stockCode", "year"}) // 종목코드 + 연도 중복 방지
        }
)
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
    private Long thstrm_amount;    // 당기순이익

    // 이걸로 교체
    private Double dividendYield; // 현금배당수익률(%) 보통주
    private String stlmDt;        // 결산일
    private Double AAAA;          // 주당현금배당원
    private boolean 보통주;



}
