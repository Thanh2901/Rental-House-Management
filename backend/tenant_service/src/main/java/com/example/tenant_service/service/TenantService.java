package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantDTO;
import com.example.tenant_service.entity.Tenant;

import java.util.List;

public interface TenantService {
    TenantDTO createTenant(TenantDTO tenantDTO);
    TenantDTO updateTenant(int id, Tenant tenant);
    TenantDTO getTenantById(int id);
    List<TenantDTO> getAllTenant();
    void deleteTenant(int id);
}
