package com.example.finance_service.service;

import com.example.finance_service.dto.FinanceDTO;
import com.example.finance_service.dto.request.FinanceRequest;
import com.example.finance_service.entity.Finance;
import com.example.finance_service.entity.Invoice;
import com.example.finance_service.mapper.FinanceMapper;
import com.example.finance_service.repository.FinanceRepository;
import com.example.finance_service.repository.InvoiceRepository;
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
    @Autowired
    private InvoiceRepository invoiceRepository;

    public FinanceDTO createFinance(FinanceRequest request) {
        Invoice invoice = invoiceRepository.findById(request.getInvoiceId()).orElseThrow(() -> new RuntimeException("invoice id is not existed"));
        Finance finance = financeMapper.toFinance(request);
        finance.setInvoice(invoice);
        return financeMapper.toFinanceDTO(financeRepository.save(finance));
    }

    public List<FinanceDTO> getAllFinances() {
        return financeRepository.findAll().stream().map(financeMapper::toFinanceDTO).collect(Collectors.toList());
    }

    public FinanceDTO getFinanceById(String id) {
        return financeMapper.toFinanceDTO(financeRepository.findById(id).orElseThrow(() -> new RuntimeException("finance not found")));
    }

}
