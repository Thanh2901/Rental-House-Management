package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantDTO;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.mapper.TenantMapper;
import com.example.tenant_service.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private TenantMapper tenantMapper;


    public TenantDTO createTenant(Tenant tenant) {
        Tenant savedTenant = tenantRepository.save(tenant);
        return tenantMapper.toTenantDTO(savedTenant);
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
