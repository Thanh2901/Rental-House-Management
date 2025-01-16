package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantVehicleDTO;
import com.example.tenant_service.dto.request.TenantVehicleRequest;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.entity.TenantVehicle;
import com.example.tenant_service.entity.TenantVehicleType;
import com.example.tenant_service.mapper.TenantVehicleMapper;
import com.example.tenant_service.repository.TenantRepository;
import com.example.tenant_service.repository.TenantVehicleRepository;
import com.example.tenant_service.repository.TenantVehicleTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TenantVehicleService {
    @Autowired
    TenantVehicleRepository tenantVehicleRepository;
    @Autowired
    TenantVehicleMapper tenantVehicleMapper;
    @Autowired
    TenantVehicleTypeRepository tenantVehicleTypeRepository;
    @Autowired
    TenantRepository tenantRepository;

    public TenantVehicleDTO createTenantVehicle(TenantVehicleRequest request){
        TenantVehicle tenantVehicle = tenantVehicleMapper.toTenantVehicle(request);
        Tenant tenant = tenantRepository.findById(request.getTenantId()).orElseThrow(() -> new RuntimeException("Tenant with id " + request.getTenantId() + " not found"));
        TenantVehicleType tenantVehicleType = tenantVehicleTypeRepository.findById(request.getTenantVehicleTypeId()).orElseThrow(() -> new RuntimeException("Vehicle type with id " + request.getTenantVehicleTypeId() + " not found"));
        tenantVehicle.setTenant(tenant);
        tenantVehicle.setTenantVehicleType(tenantVehicleType);
        TenantVehicle savedTenantVehicle = tenantVehicleRepository.save(tenantVehicle);
        return tenantVehicleMapper.toTenantVehicleDTO(savedTenantVehicle);
    }

    public TenantVehicleDTO getVehicleById(int id){
        return tenantVehicleMapper.toTenantVehicleDTO(tenantVehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle " + id + " not found")));
    }

    public List<TenantVehicleDTO> getAllVehicles(){
        return tenantVehicleRepository.findAll().stream().map(tenantVehicleMapper::toTenantVehicleDTO).collect(Collectors.toList());
    }

    public void deleteTenantVehicle(int id){
        if(tenantRepository.existsById(id)){
            throw new RuntimeException("Vehicle " + id + " not found");
        }
        tenantVehicleRepository.deleteById(id);
    }
}
