package com.example.demo.Dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InvestmentResultDto {

    private String companyName;

    private double per;
    private double pbr;
    private double roe;
}