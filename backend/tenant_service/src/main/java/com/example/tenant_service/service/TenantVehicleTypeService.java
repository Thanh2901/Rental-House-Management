package com.example.tenant_service.service;

import com.example.tenant_service.dto.request.TenantVehicleTypeRequest;
import com.example.tenant_service.dto.response.TenantVehicleTypeResponse;
import com.example.tenant_service.entity.TenantVehicleType;
import com.example.tenant_service.mapper.TenantVehicleTypeMapper;
import com.example.tenant_service.repository.TenantVehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantVehicleTypeService {
    @Autowired
    TenantVehicleTypeRepository tenantVehicleTypeRepository;
    @Autowired
    TenantVehicleTypeMapper tenantVehicleTypeMapper;


    public TenantVehicleType createVehicleType(TenantVehicleTypeRequest request){
        TenantVehicleType tenantVehicleType = tenantVehicleTypeMapper.toTenantVehicleType(request);
        tenantVehicleType = tenantVehicleTypeRepository.save(tenantVehicleType);
        return tenantVehicleType;
    }

    public List<TenantVehicleType> getAllTenantVehicleType(){
        return tenantVehicleTypeRepository.findAll();
    }

    public TenantVehicleTypeResponse getTenantVehicleTypeById(Long id){
        TenantVehicleType tenantVehicleType = tenantVehicleTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("vehicle type not found"));
        return tenantVehicleTypeMapper.toTenantVehicleTypeResponse(tenantVehicleType);
    }


    public TenantVehicleType updateTenantVehicleType(Long id, TenantVehicleTypeRequest request){
        TenantVehicleType tenantVehicleType = tenantVehicleTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle type not found"));
        tenantVehicleType = tenantVehicleTypeMapper.updateTenantVehicleType(tenantVehicleType, request);
        return tenantVehicleTypeRepository.save(tenantVehicleType);
    }

    public void deleteTenantVehicleType(Long id){
        tenantVehicleTypeRepository.deleteById(id);
    }
}
