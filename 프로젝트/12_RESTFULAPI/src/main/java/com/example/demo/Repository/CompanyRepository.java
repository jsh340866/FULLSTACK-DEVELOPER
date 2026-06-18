package com.example.demo.Repository;

import com.example.demo.Entity.Company;
import jdk.jfr.Registered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Registered
public interface CompanyRepository extends JpaRepository<Company, String> {

    /**
     * 전체 상장 종목 코드만 조회
     */
    @Query("SELECT c.stockCode FROM Company c WHERE c.stockCode IS NOT NULL")
    List<String> findAllStockCodes();

    Page<Company> findAll(Pageable pageable);

    @Query("SELECT c.stockCode FROM Company c")
    Page<String> findAllStockCodes(Pageable pageable);

}
