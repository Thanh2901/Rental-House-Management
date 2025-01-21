package com.example.finance_service.service;

import com.example.finance_service.client.TenantClient;
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
    @Autowired
    private TenantClient tenantClient;

    public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
        int tenantId = invoiceDTO.getTenant_id();
        try {
            tenantClient.getTenantById(tenantId);
            System.out.println("Tenant found: " + tenantId);
        } catch (RuntimeException e) {
            throw new RuntimeException("Tenant with ID " + tenantId + " does not exist.");
        }
        // Lưu invoice
        Invoice invoice = invoiceMapper.toInvoice(invoiceDTO);
        invoice.setTenant_id(tenantId);
        Invoice savedInvoice = invoiceRepository.save(invoice);

        // Thiết lập quan hệ cho tài chính nếu có
        savedInvoice.getFinances().forEach(finance -> {
            if (finance != null) {
                finance.setInvoice(savedInvoice);
            }
        });
        return invoiceMapper.toInvoiceDTO(savedInvoice);
    }


    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream().map(invoiceMapper::toInvoiceDTO).collect(Collectors.toList());
    }

    public InvoiceDTO getInvoiceById(String id) {
        return invoiceMapper.toInvoiceDTO(invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("invoice not found")));
    }

    public InvoiceDTO updateInvoice(String id, InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("invoice not found"));
        invoiceMapper.updateInvoice(invoice, invoiceDTO);
        int tenantId = invoiceDTO.getTenant_id();
        try {
            tenantClient.getTenantById(tenantId);
            System.out.println("Tenant found: " + tenantId);
        } catch (RuntimeException e) {
            throw new RuntimeException("Tenant with ID " + tenantId + " does not exist.");
        }
        invoice.setTenant_id(tenantId);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.toInvoiceDTO(savedInvoice);
    }

    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
    }
}
