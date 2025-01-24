package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantVehicleDTO;
import com.example.tenant_service.dto.request.TenantVehicleRequest;

import java.util.List;

public interface TenantVehicleService {
    TenantVehicleDTO createTenantVehicle(TenantVehicleRequest request);
    TenantVehicleDTO getVehicleById(int id);
    List<TenantVehicleDTO> getAllVehicles();
    void deleteTenantVehicle(int id);
}
