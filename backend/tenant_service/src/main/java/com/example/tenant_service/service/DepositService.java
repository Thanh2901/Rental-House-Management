package com.example.tenant_service.service;

import com.example.tenant_service.dto.DepositDTO;
import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.entity.Deposit;

import java.util.List;

public interface DepositService {
    DepositDTO addDeposit(DepositRequest depositRequest);
    DepositDTO updateDeposit(int id, Deposit deposit);
    DepositDTO getDepositById(int id);
    List<DepositDTO> getDepositByTenantId(int tenantId);
    void deleteDepositById(int id);
}
