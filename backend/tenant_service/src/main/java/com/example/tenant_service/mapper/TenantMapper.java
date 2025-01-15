package com.example.tenant_service.mapper;

import com.example.tenant_service.dto.TenantDTO;
import com.example.tenant_service.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    @Mapping(source = "tenantId", target = "id")
    TenantDTO toTenantDTO(Tenant tenant);
}
