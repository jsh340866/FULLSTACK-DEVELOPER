package com.example.demo.Repository;

import com.example.demo.Entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
    /**
     * 종목 + 날짜 기준 중복 체크
     */
    Optional<StockPrice> findByStockCodeAndTradeDate(
            String stockCode,
            LocalDate tradeDate
    );
    Optional<StockPrice> findTopByStockCodeOrderByTradeDateDesc(String stockCode);
}