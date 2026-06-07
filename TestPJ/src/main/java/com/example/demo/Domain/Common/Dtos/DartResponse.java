package com.example.demo.Domain.Common.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class DartResponse {
    private String status;
    private List<DartItem> list;
}