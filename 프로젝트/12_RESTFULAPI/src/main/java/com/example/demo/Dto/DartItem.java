package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DartItem {

    @JsonProperty("account_nm")
    private String accountNm;

    @JsonProperty("thstrm_amount")
    private String amount;
}
