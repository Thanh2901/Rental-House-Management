package com.example.tenant_service.service;

import com.example.tenant_service.dto.request.TenantRequest;
import com.example.tenant_service.dto.response.TenantResponse;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.mapper.TenantMapper;
import com.example.tenant_service.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private TenantMapper tenantMapper;


    public Tenant createTenant(TenantRequest tenantDTO) {
        Tenant tenant = tenantMapper.toTenant(tenantDTO);
        tenant = tenantRepository.save(tenant);
        return tenant;
    }
    public TenantResponse getTenantById(int id){
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new RuntimeException("tenant can not found"));
        return tenantMapper.toTenantResponse(tenant);
    }
    public void deleteTenant(int id){
        tenantRepository.deleteById(id);
    }
}
