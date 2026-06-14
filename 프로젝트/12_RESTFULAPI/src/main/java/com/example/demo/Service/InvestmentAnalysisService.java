//package com.example.demo.Service;
//
//import com.example.demo.Dto.InvestmentResultDto;
//import com.example.demo.Entity.Company;
//import com.example.demo.Entity.Financial;
//import com.example.demo.Entity.StockPrice;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class InvestmentAnalysisService {
//
//    public InvestmentResultDto analyze(
//            Company company,
//            Financial financial,
//            StockPrice stockPrice,
//            Long shares   // 📌 중요: 주식수는 Financial에 없음
//    ) {
//
//        double price = stockPrice.getClosePrice();
//
//        // 📌 재무 데이터 (엔티티 그대로 사용)
//        double netIncome = financial.getNetIncome();
//        double equity = financial.getEquity();
//
//        // 📌 주당 지표 (직접 계산)
//        double eps = (shares != null && shares != 0)
//                ? netIncome / shares
//                : 0;
//
//        double bps = (shares != null && shares != 0)
//                ? equity / shares
//                : 0;
//
//        // 📌 투자 지표
//        double per = (eps != 0) ? price / eps : 0;
//        double pbr = (bps != 0) ? price / bps : 0;
//        double roe = (equity != 0)
//                ? (netIncome / equity) * 100
//                : 0;
//
//        return InvestmentResultDto.builder()
//                .companyName(company.getName())
//                .per(per)
//                .pbr(pbr)
//                .roe(roe)
//                .build();
//    }
//}