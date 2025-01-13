package com.example.finance_service.repository;

import com.example.finance_service.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<Finance, String> {
}
