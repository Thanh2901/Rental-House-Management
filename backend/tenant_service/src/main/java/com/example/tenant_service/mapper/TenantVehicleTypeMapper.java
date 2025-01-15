package com.example.tenant_service.mapper;

import com.example.tenant_service.dto.TenantVehicleTypeDTO;
import com.example.tenant_service.entity.TenantVehicleType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TenantVehicleTypeMapper {
    TenantVehicleTypeDTO toTenantVehicleTypeDTO(TenantVehicleType tenantVehicleType);
}
