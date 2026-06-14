package com.example.demo.Dto;

import lombok.Data;

import java.util.List;

@Data
public class DartResponse {

    private String status;
    private String message;

    private List<DartItem> list;
}
