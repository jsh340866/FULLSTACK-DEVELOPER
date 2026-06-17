// FinancialIndicatorRepository.java
package com.example.demo.Repository;

import com.example.demo.Entity.FinancialIndicator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialIndicatorRepository extends JpaRepository<FinancialIndicator, Long> {
    // 기본 CRUD는 JpaRepository가 자동 제공
}