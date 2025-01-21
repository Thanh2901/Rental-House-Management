package com.example.room_service.service;

import com.example.room_service.client.TenantClient;
import com.example.room_service.dto.ContractDTO;
import com.example.room_service.dto.request.ContractRequest;
import com.example.room_service.entity.Contract;
import com.example.room_service.entity.Room;
import com.example.room_service.mapper.ContractMapper;
import com.example.room_service.repository.ContractRepository;
import com.example.room_service.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TenantClient tenantClient;

    public ContractDTO createContract(ContractRequest request) {
        Contract contract = contractMapper.toContract(request);
        Room room = roomRepository.findById(request.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        try {
            tenantClient.getTenantById(request.getTenant_id());
            System.out.println("Tenant id" + request.getTenant_id() + "found");
        } catch (RuntimeException e)  {
            throw new RuntimeException("Tenant not found");
        }
        contract.setRoom(room);
        contract.setTenant_id(request.getTenant_id());
        Contract saved = contractRepository.save(contract);
        return contractMapper.toContractDTO(saved);

    }

    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll().stream().map(contractMapper::toContractDTO).toList();
    }

    public ContractDTO getContractById(String id) {
        return contractMapper.toContractDTO(contractRepository.findById(id).orElseThrow(() -> new RuntimeException("contract not found")));
    }

    public ContractDTO updateContract(String id, ContractRequest request) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new RuntimeException("contract not found"));
        contractMapper.updateContract(contract, request);
        Room room = roomRepository.findById(request.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        try {
            tenantClient.getTenantById(request.getTenant_id());
            System.out.println("Tenant id" + request.getTenant_id() + "found");
        } catch (RuntimeException e)  {
            throw new RuntimeException("Tenant not found");
        }
        contract.setRoom(room);
        contract.setTenant_id(request.getTenant_id());
        Contract saved = contractRepository.save(contract);
        return contractMapper.toContractDTO(saved);
    }

    public void deleteContract(String id) {
        contractRepository.deleteById(id);
    }
}
