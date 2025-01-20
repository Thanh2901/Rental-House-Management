package com.example.finance_service.controller;

import com.example.finance_service.dto.FinanceDTO;
import com.example.finance_service.dto.request.FinanceRequest;
import com.example.finance_service.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @PostMapping("/add")
    public ResponseEntity<FinanceDTO> addFinance(@RequestBody FinanceRequest request) {
        return ResponseEntity.ok(financeService.createFinance(request));
    }
}
