package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String corpCode;

    private Long netIncome;   // 당기순이익
    private Long equity;      // 자본총계
    private Long liability;   // 부채총계

    private Double debtRatio; // 부채비율

    private String bsnsYear;  // 기준연도
}