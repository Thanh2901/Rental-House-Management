package com.example.finance_service.controller;

import com.example.finance_service.dto.InvoiceDTO;
import com.example.finance_service.service.InvoiceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class InvoiceController {

    InvoiceService invoiceService;

    @PostMapping("/add")
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoice) {
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<InvoiceDTO>> getInvoiceList() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable String id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InvoiceDTO> updateInvoice(@PathVariable String id, @RequestBody InvoiceDTO invoice) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, invoice));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable String id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok("Invoice deleted" + id);
    }
}
