package com.example.demo.Dto;

import lombok.Data;

@Data
public class StockPriceDto {

    private String stockCode;
    private String tradeDate;

    private Long openPrice;
    private Long closePrice;
    private Long highPrice;
    private Long lowPrice;

    private Long volume;
    private Long amount;

    private Double changeRate;
    private Long changePrice;
}
