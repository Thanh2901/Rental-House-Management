package com.example.finance_service.service;

import com.example.finance_service.dto.FinanceDTO;
import com.example.finance_service.entity.Finance;
import com.example.finance_service.mapper.FinanceMapper;
import com.example.finance_service.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceService {
    @Autowired
    private FinanceRepository financeRepository;
    @Autowired
    private FinanceMapper financeMapper;

    public FinanceDTO createFinance(Finance finance) {
        return financeMapper.toFinanceDTO(financeRepository.save(finance));
    }

    public List<FinanceDTO> getAllFinances() {
        return financeRepository.findAll().stream().map(financeMapper::toFinanceDTO).collect(Collectors.toList());
    }

    public FinanceDTO getFinanceById(String id) {
        return financeMapper.toFinanceDTO(financeRepository.findById(id).orElseThrow(() -> new RuntimeException("finance not found")));
    }

}
