package com.example.tenant_service.controller;

import com.example.tenant_service.dto.DepositDTO;
import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.entity.Deposit;
import com.example.tenant_service.service.DepositService;
import com.example.tenant_service.service.DepositServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposit")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepositController {
    DepositService depositService;

    @PostMapping("/add")
    public ResponseEntity<DepositDTO> addDeposit(@RequestBody DepositRequest request){
        return ResponseEntity.ok(depositService.addDeposit(request));
    }

    @PutMapping("/update/{depositId}")
    public ResponseEntity<DepositDTO> updateDeposit(@PathVariable int depositId, @RequestBody Deposit request){
        return ResponseEntity.ok(depositService.updateDeposit(depositId, request));
    }

    @DeleteMapping("/delete/{depositId}")
    public ResponseEntity<String> deleteDeposit(@PathVariable int depositId){
        depositService.deleteDepositById(depositId);
        return ResponseEntity.ok("Deposit deleted successfully");
    }

    @GetMapping("/get/{depositId}")
    public ResponseEntity<DepositDTO> getDepositById(@PathVariable int depositId){
        return ResponseEntity.ok(depositService.getDepositById(depositId));
    }

}
