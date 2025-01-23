package com.example.finance_service.controller;

import com.example.finance_service.dto.FinanceDTO;
import com.example.finance_service.dto.request.FinanceRequest;
import com.example.finance_service.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @PostMapping("/add")
    public ResponseEntity<FinanceDTO> addFinance(@RequestBody FinanceRequest request) {
        return ResponseEntity.ok(financeService.createFinance(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<FinanceDTO>> getFinanceList() {
        return ResponseEntity.ok(financeService.getAllFinances());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FinanceDTO> getFinanceById(@PathVariable String id) {
        return ResponseEntity.ok(financeService.getFinanceById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FinanceDTO> updateFinance(@PathVariable String id, @RequestBody FinanceRequest request) {
        return ResponseEntity.ok(financeService.updateFinance(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFinance(@PathVariable String id) {
        financeService.deleteFinance(id);
        return ResponseEntity.ok("Deleted finance" + id);
    }
}
