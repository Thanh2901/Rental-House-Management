package com.example.room_service.service;

import com.example.room_service.dto.ContractDTO;
import com.example.room_service.dto.request.ContractRequest;

import java.util.List;

public interface ContractService {
    ContractDTO createContract(ContractRequest request);
    List<ContractDTO> getAllContracts();
    ContractDTO getContractById(String id);
    ContractDTO updateContract(String id, ContractRequest request);
    void deleteContract(String id);
}
