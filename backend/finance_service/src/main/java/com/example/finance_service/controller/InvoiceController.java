package com.example.finance_service.controller;

import com.example.finance_service.dto.InvoiceDTO;
import com.example.finance_service.entity.Invoice;
import com.example.finance_service.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping()
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoice) {
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }


}
