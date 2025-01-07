package com.example.tenant_service.mapper;

import com.example.tenant_service.dto.request.TenantRequest;
import com.example.tenant_service.dto.response.TenantResponse;
import com.example.tenant_service.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    Tenant toTenant(TenantRequest request);
    Tenant updateTenant(@MappingTarget Tenant tenant, TenantRequest request);
    TenantResponse toTenantResponse(Tenant tenant);
}
