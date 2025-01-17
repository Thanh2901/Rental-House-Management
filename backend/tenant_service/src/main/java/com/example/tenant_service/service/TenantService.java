package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantDTO;
import com.example.tenant_service.entity.Deposit;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.mapper.TenantMapper;
import com.example.tenant_service.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private TenantMapper tenantMapper;


    public TenantDTO createTenant(TenantDTO tenantDTO) {
        Tenant tenant = tenantMapper.toTenant(tenantDTO);
        tenantRepository.save(tenant);
        return tenantMapper.toTenantDTO(tenant);
    }

    public TenantDTO updateTenant(int id, Tenant tenant){
        Tenant updatedTenant = tenantRepository.findById(id).orElseThrow(() -> new RuntimeException("Tenant with " + id + " not found"));
        updatedTenant.setFullName(tenant.getFullName());
        updatedTenant.setPhoneNumber(tenant.getPhoneNumber());
        updatedTenant.setIdCardPassport(tenant.getIdCardPassport());
        updatedTenant.setRentalStartDate(tenant.getRentalStartDate());
        tenantRepository.save(updatedTenant);
        return tenantMapper.toTenantDTO(updatedTenant);
    }

    public TenantDTO getTenantById(int id){
        return tenantMapper.toTenantDTO(tenantRepository.findById(id).orElseThrow(() -> new RuntimeException("tenant not found")));
    }
    public List<TenantDTO> getAllTenant(){
        return tenantRepository.findAll().stream().map(tenantMapper::toTenantDTO).collect(Collectors.toList());
    }
    public void deleteTenant(int id){
        tenantRepository.deleteById(id);
    }
}
