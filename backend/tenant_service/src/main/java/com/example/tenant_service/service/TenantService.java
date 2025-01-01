package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantDTO;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.mapper.TenantMapper;
import com.example.tenant_service.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private TenantMapper tenantMapper;

    public Tenant createTenant(TenantDTO tenantDTO){
        Tenant tenant = tenantMapper.toTenant(tenantDTO);
        tenant = tenantRepository.save(tenant);
        return tenant;
    }
}
