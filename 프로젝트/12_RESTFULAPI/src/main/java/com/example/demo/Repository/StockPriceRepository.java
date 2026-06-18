package com.example.demo.Repository;

import com.example.demo.Entity.StockPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT c.stockCode FROM Company c")
    Page<String> findAllStockCodes(Pageable pageable); // 종목코드 전체를 페이징으로 조회
}