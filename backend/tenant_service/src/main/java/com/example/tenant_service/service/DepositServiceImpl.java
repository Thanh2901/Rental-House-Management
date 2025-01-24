package com.example.tenant_service.service;


import com.example.tenant_service.dto.DepositDTO;
import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.entity.Deposit;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.mapper.DepositMapper;
import com.example.tenant_service.repository.DepositRepository;
import com.example.tenant_service.repository.TenantRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {
    DepositRepository depositRepository;
    DepositMapper depositMapper;
    TenantRepository tenantRepository;

    public DepositDTO addDeposit(DepositRequest depositRequest) {
        if (depositRequest.getDepositAmount() <= 0) {
            throw new RuntimeException("Deposit amount must be positive");
        }
        Deposit deposit = depositMapper.toDeposit(depositRequest);
        Tenant tenant = tenantRepository.findById(depositRequest.getTenantId())
                .orElseThrow(() -> new RuntimeException("Tenant with id " + depositRequest.getTenantId() + " not found"));
        deposit.setTenant(tenant);
        Deposit savedDeposit = depositRepository.save(deposit);
        return depositMapper.toDepositDTO(savedDeposit);
    }

    public DepositDTO updateDeposit(int id, Deposit deposit){
        Deposit updatedDeposit = depositRepository.findById(id).orElseThrow(() -> new RuntimeException("deposit not found"));
        if(deposit.getDepositAmount() != updatedDeposit.getDepositAmount()){
            updatedDeposit.setDepositAmount(deposit.getDepositAmount());
        }
        if(deposit.getDepositDate() != updatedDeposit.getDepositDate()){
            updatedDeposit.setDepositDate(deposit.getDepositDate());
        }
        updatedDeposit.setDepositAmount(deposit.getDepositAmount());
        updatedDeposit.setDepositDate(deposit.getDepositDate());
        depositRepository.save(updatedDeposit);
        return depositMapper.toDepositDTO(updatedDeposit);
    }

    public DepositDTO getDepositById(int id){
        Deposit deposit = depositRepository.findById(id).orElseThrow(() -> new RuntimeException("Deposit with id " + id + " not found"));
        return depositMapper.toDepositDTO(deposit);
    }

    public List<DepositDTO> getDepositByTenantId(int tenantId){
        return null;
    }

    public void deleteDepositById(int id){
        if(!depositRepository.existsById(id)){
            throw new RuntimeException("Deposit with id " + id + " not found");
        }
        depositRepository.deleteById(id);
    }
}
