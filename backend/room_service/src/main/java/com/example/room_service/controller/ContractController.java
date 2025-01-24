package com.example.room_service.controller;

import com.example.room_service.dto.ContractDTO;
import com.example.room_service.dto.request.ContractRequest;
import com.example.room_service.service.ContractService;
import com.example.room_service.service.ContractServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ContractController {
    ContractService contractService;

    @PostMapping("/add")
    public ResponseEntity<ContractDTO> addContract(@RequestBody ContractRequest request) {
        return ResponseEntity.ok(contractService.createContract(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ContractDTO> getContract(@PathVariable String id) {
        return ResponseEntity.ok(contractService.getContractById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContractDTO> updateContract(@PathVariable String id, @RequestBody ContractRequest request) {
        return ResponseEntity.ok(contractService.updateContract(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContract(@PathVariable String id) {
        contractService.deleteContract(id);
        return ResponseEntity.ok("Deleted contract " + id);
    }
}
