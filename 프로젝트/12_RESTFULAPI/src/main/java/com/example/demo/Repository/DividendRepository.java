package com.example.demo.Repository;

import com.example.demo.Entity.Dividend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DividendRepository extends JpaRepository<Dividend, Dividend.DividendId> {

    boolean existsById(Dividend.DividendId id);

    List<Dividend> findByIdStockCode(String stockCode);

    Optional<Dividend> findByIdStockCodeAndIdYearAndIdStockType(String stockCode, int year, Dividend.StockType stockType);
}