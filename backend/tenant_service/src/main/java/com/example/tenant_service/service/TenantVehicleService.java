package com.example.tenant_service.service;

import com.example.tenant_service.dto.request.TenantVehicleRequest;
import com.example.tenant_service.dto.response.TenantVehicleResponse;
import com.example.tenant_service.entity.TenantVehicle;
import com.example.tenant_service.entity.TenantVehicleType;
import com.example.tenant_service.mapper.TenantVehicleMapper;
import com.example.tenant_service.repository.TenantVehicleRepository;
import com.example.tenant_service.repository.TenantVehicleTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TenantVehicleService {
    @Autowired
    TenantVehicleRepository tenantVehicleRepository;
    @Autowired
    TenantVehicleMapper tenantVehicleMapper;
    @Autowired
    TenantVehicleTypeRepository tenantVehicleTypeRepository;

    public TenantVehicle createTenantVehicle(TenantVehicleRequest tenantVehicleRequest){
        TenantVehicleType tenantVehicleType = tenantVehicleTypeRepository.findById(tenantVehicleRequest.getVehicleTypeId()).orElseThrow(() -> new RuntimeException("vehicle type not found"));
        TenantVehicle tenantVehicle = tenantVehicleMapper.toTenantVehicle(tenantVehicleRequest);
        tenantVehicle.setTenantVehicleType(tenantVehicleType);
        return tenantVehicleRepository.save(tenantVehicle);
    }
    public TenantVehicleResponse getVehicleById(int id){
        TenantVehicle tenantVehicle = tenantVehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle cant be found"));
        return tenantVehicleMapper.toTenantVehicleResponse(tenantVehicle);
    }

    public void deleteTenantVehicle(int id){
        tenantVehicleRepository.deleteById(id);
    }
}
