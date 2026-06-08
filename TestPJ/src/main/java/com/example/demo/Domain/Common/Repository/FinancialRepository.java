package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Financial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FinancialRepository extends JpaRepository<Financial, Long> {

    Optional<Financial> findByCorpCodeAndBsnsYear(String corpCode, String bsnsYear);

}