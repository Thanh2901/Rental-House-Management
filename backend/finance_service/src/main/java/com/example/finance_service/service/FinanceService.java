package com.example.finance_service.service;

import com.example.finance_service.dto.FinanceDTO;
import com.example.finance_service.dto.request.FinanceRequest;

import java.util.List;

public interface FinanceService {
    FinanceDTO createFinance(FinanceRequest request);
    List<FinanceDTO> getAllFinances();
    FinanceDTO getFinanceById(String id);
    FinanceDTO updateFinance(String id, FinanceRequest request);
    void deleteFinance(String id);
}
