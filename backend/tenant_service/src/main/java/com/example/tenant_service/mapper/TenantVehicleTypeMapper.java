package com.example.tenant_service.mapper;

import com.example.tenant_service.dto.request.TenantVehicleTypeRequest;
import com.example.tenant_service.dto.response.TenantVehicleTypeResponse;
import com.example.tenant_service.entity.TenantVehicleType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TenantVehicleTypeMapper {
    TenantVehicleType toTenantVehicleType(TenantVehicleTypeRequest request);
    TenantVehicleType updateTenantVehicleType(@MappingTarget TenantVehicleType tenantVehicleType, TenantVehicleTypeRequest tenantVehicleTypeRequest);
    TenantVehicleTypeResponse toTenantVehicleTypeResponse(TenantVehicleType tenantVehicleType);
}
