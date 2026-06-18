package com.example.demo.Repository;

import com.example.demo.Entity.Company;
import com.example.demo.Entity.Financial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Repository
public interface FinancialRepository extends JpaRepository<Financial, Long> {

    List<Financial> findByStockCode(String stockCode);

    Optional<Financial> findByStockCodeAndYear(String stockCode, Integer year); // 이미 있으면 스킵용

}
