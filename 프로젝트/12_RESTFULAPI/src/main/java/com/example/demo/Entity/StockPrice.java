package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"stockCode", "tradeDate"}) // 중복 방지
        },
        indexes = {
                @Index(name = "idx_stock_date", columnList = "stockCode, tradeDate") // 조회 최적화
        }
)
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    private String stockCode; // 종목코드
    private LocalDate tradeDate; // 거래일

    private Long openPrice; // 시가
    private Long closePrice; // 종가
    private Long highPrice; // 고가
    private Long lowPrice; // 저가

    private Long volume; // 거래량
    private Long amount; // 거래대금

    private Long changePrice; // 등락폭
    private Double changeRate; // 등락률 (%)

    private String mrktCtg; // 코스닥, 코스피
}