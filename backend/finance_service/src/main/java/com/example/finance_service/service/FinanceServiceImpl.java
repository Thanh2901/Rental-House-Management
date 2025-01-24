package com.example.finance_service.service;

import com.example.finance_service.dto.FinanceDTO;
import com.example.finance_service.dto.request.FinanceRequest;
import com.example.finance_service.entity.Finance;
import com.example.finance_service.entity.Invoice;
import com.example.finance_service.mapper.FinanceMapper;
import com.example.finance_service.repository.FinanceRepository;
import com.example.finance_service.repository.InvoiceRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService{

      FinanceRepository financeRepository;

      FinanceMapper financeMapper;

      InvoiceRepository invoiceRepository;

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

    public FinanceDTO updateFinance(String id, FinanceRequest request) {
        Finance finance = financeRepository.findById(id).orElseThrow(() -> new RuntimeException("finance not found"));
        financeMapper.updateFinance(finance, request);
        Invoice invoice = invoiceRepository.findById(request.getInvoiceId()).orElseThrow(() -> new RuntimeException("invoice id is not existed"));
        finance.setInvoice(invoice);
        financeRepository.save(finance);
        return financeMapper.toFinanceDTO(finance);
    }

    public void deleteFinance(String id) {
        financeRepository.deleteById(id);
    }
}
