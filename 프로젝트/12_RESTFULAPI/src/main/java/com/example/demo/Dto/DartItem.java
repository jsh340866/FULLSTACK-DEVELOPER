package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DartItem {

    @JsonProperty("account_nm")
    private String accountNm;

    @JsonProperty("thstrm_amount")
    private String amount;

    @JsonProperty("se")
    private String se;          // 구분 (현금배당수익률(%) 등)

    @JsonProperty("stock_knd")
    private String stockKnd;    // 주식 종류 (보통주/우선주)

    @JsonProperty("thstrm")
    private String thstrm;      // 당기 값

    @JsonProperty("stlm_dt")
    private String stlmDt;      // 결산일
}
