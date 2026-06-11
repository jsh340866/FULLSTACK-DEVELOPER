package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {

    Optional<StockPrice> findByStockCodeAndBasDt(String stockCode, String basDt);
}
