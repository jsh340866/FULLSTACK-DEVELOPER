package com.example.demo.Domain.Common.Dtos;

import lombok.Data;

@Data
public class DartItem {
    private String account_nm;     // 계정명
    private String thstrm_amount;  // 당기금액
    private String bsns_year;
}
