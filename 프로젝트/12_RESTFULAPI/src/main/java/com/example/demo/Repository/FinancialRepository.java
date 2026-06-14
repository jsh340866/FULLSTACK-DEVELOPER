package com.example.demo.Repository;

import com.example.demo.Entity.Financial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialRepository extends JpaRepository<Financial, Long> {

    List<Financial> findByStockCode(String stockCode);

}
