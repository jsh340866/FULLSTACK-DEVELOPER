package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByStockCode(String stockCode);
}