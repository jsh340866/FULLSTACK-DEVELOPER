package com.example.demo.Domain.Common.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CorpCodeItem {

    @JacksonXmlProperty(localName = "corp_code")
    private String corpCode;

    @JacksonXmlProperty(localName = "corp_name")
    private String corpName;

    @JacksonXmlProperty(localName = "stock_code")
    private String stockCode;




}
