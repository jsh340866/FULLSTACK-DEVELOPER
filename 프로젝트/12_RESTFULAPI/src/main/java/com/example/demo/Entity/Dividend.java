package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "dividend")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dividend {

    @EmbeddedId
    private DividendId id;

    @Column(name = "dividend_yield")
    private Double dividendYield;       // 현금배당수익률 (%)

    @Column(name = "dividend_per_share")
    private Double dividendPerShare;    // 주당현금배당금

    @Column(name = "stlm_dt")
    private String stlmDt;             // 결산일

    @Embeddable
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class DividendId implements Serializable {

        @Column(name = "stock_code")
        private String stockCode;

        @Column(name = "year")
        private Integer year;

        @Enumerated(EnumType.STRING)
        @Column(name = "stock_type")
        private StockType stockType;
    }

    public enum StockType {
        COMMON,     // 보통주
        PREFERRED   // 우선주
    }
}