package com.example.tenant_service.controller;

import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.dto.response.DepositResponse;
import com.example.tenant_service.entity.Deposit;
import com.example.tenant_service.service.DepositService;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposit")
public class DepositController {
    @Autowired
    private DepositService depositService;

    @PostMapping("/add")
    public ResponseEntity<Deposit> addDeposit(@RequestBody DepositRequest request){
        return ResponseEntity.ok(depositService.addDeposit(request));
    }

    @PutMapping("/update/{depositId}")
    public ResponseEntity<Deposit> updateDeposit(@PathVariable int depositId, @RequestBody DepositRequest request){
        return ResponseEntity.ok(depositService.updateDeposit(depositId, request));
    }

    @DeleteMapping("/delete/{depositId}")
    public ResponseEntity<String> deleteDeposit(@PathVariable int depositId){
        depositService.deleteDepositById(depositId);
        return ResponseEntity.ok("Deposit deleted successfully");
    }

    @GetMapping("/get/{depositId}")
    public ResponseEntity<DepositResponse> getDepositById(@PathVariable int depositId){
        return ResponseEntity.ok(depositService.getDepositById(depositId));
    }

}
