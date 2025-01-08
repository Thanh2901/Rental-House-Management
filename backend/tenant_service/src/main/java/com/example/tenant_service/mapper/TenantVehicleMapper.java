package com.example.tenant_service.mapper;

import com.example.tenant_service.dto.request.TenantVehicleRequest;
import com.example.tenant_service.dto.response.TenantVehicleResponse;
import com.example.tenant_service.entity.TenantVehicle;
import com.example.tenant_service.entity.TenantVehicleType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TenantVehicleMapper {
    TenantVehicle toTenantVehicle(TenantVehicleRequest request);
    TenantVehicle updateTenantVehicle(@MappingTarget TenantVehicle tenantVehicle, TenantVehicleRequest request);
    @Mapping(source = "vehicleId", target = "id")
    TenantVehicleResponse toTenantVehicleResponse(TenantVehicle tenantVehicle);
}
