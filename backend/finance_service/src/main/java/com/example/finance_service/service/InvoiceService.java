package com.example.finance_service.service;

import com.example.finance_service.dto.InvoiceDTO;
import com.example.finance_service.entity.Invoice;
import com.example.finance_service.mapper.InvoiceMapper;
import com.example.finance_service.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceMapper invoiceMapper;

    public InvoiceDTO createInvoice(Invoice invoice) {
        Invoice savedInvoice = invoiceRepository.save(invoice);
        savedInvoice.getFinances().forEach(finance -> {
            if (finance != null) {
                finance.setInvoice(savedInvoice);
            }
            System.out.println("Found a null finance object in the list!");
        });
        return invoiceMapper.toInvoiceDTO(savedInvoice);
    }

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream().map(invoiceMapper::toInvoiceDTO).collect(Collectors.toList());
    }

    public InvoiceDTO getInvoiceById(String id) {
        return invoiceMapper.toInvoiceDTO(invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("invoice not found")));
    }
}
