package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    private String stockCode;   // 종목코드

    private String corpCode;    // DART 기업코드

    private String corpName;    // 회사명

    private String market;      // KOSPI, KOSDAQ

    private boolean listed;     // 상장여부
}