package com.example.finance_service.service;

import com.example.finance_service.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);
    List<InvoiceDTO> getAllInvoices();
    InvoiceDTO getInvoiceById(String id);
    InvoiceDTO updateInvoice(String id, InvoiceDTO invoiceDTO);
    void deleteInvoice(String id);
}
