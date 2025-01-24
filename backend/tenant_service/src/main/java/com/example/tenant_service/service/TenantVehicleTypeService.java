package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantVehicleTypeDTO;
import com.example.tenant_service.entity.TenantVehicleType;

import java.util.List;

public interface TenantVehicleTypeService {
    TenantVehicleTypeDTO createVehicleType(TenantVehicleType tenantVehicleType);
    List<TenantVehicleTypeDTO> getAllTenantVehicleType();
    TenantVehicleTypeDTO getTenantVehicleTypeById(Long id);
    TenantVehicleTypeDTO updateTenantVehicleType(Long id, TenantVehicleType tenantVehicleType);
    public void deleteTenantVehicleType(Long id);
}
