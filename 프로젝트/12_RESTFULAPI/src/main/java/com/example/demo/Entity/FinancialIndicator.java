package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "financial_indicator")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinancialIndicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Column(nullable = false)
    private String corpCode; // 기업코드 (재무재표 참조)

    @Column(nullable = false)
    private String stockCode; // 종목코드 (주식시세 참조)

    @Column(nullable = false)
    private Integer year; // 기준 연도

    private Double pbr; // 주가순자산비율 (시가총액 / 자본총계)
    private Double per; // 주가수익비율 (주가 / EPS)
    private Double roe; // 자기자본이익률 (순이익 / 자본총계 * 100)
    private Double eps; // 주당순이익 (순이익 / 발행주식수)
    private Double bps; // 주당순자산 (자본총계 / 발행주식수)

    private Double debtRatio; // 부채비율 (부채총계 / 자본총계 * 100)
    private Double operatingProfitMargin; // 영업이익률 (영업이익 / 매출액 * 100)
    private Double dividendYield; // 배당수익률 (배당금 / 주가 * 100) ```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
    private Long marketCap; // 시가총액 (종가 × 발행주식수)

}
