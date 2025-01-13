package com.example.tenant_service.service;


import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.dto.request.TenantRequest;
import com.example.tenant_service.dto.response.DepositResponse;
import com.example.tenant_service.entity.Deposit;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.mapper.DepositMapper;
import com.example.tenant_service.repository.DepositRepository;
import com.example.tenant_service.repository.TenantRepository;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private DepositMapper depositMapper;
    @Autowired
    private TenantRepository tenantRepository;

    public Deposit addDeposit(DepositRequest depositRequest){
        Tenant tenant = tenantRepository.findById(depositRequest.getTenantId()).orElseThrow(() -> new RuntimeException("tenant not found"));
        Deposit deposit = depositMapper.toDeposit(depositRequest);
        deposit.setTenant(tenant);
        return depositRepository.save(deposit);
    }
    public Deposit updateDeposit(int id, DepositRequest depositRequest){
        Deposit deposit = depositRepository.findById(id).orElseThrow(() -> new RuntimeException("deposit not found"));
        deposit = depositMapper.updateDeposit(deposit, depositRequest);
        return depositRepository.save(deposit);
    }
    public DepositResponse getDepositById(int id){
        Deposit deposit = depositRepository.findById(id).orElseThrow(() -> new RuntimeException("deposit not found"));
        return depositMapper.toDepositResponse(deposit);
    }

    public void deleteDepositById(int id){
        depositRepository.deleteById(id);
    }


}
