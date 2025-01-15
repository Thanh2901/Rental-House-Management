package com.example.tenant_service.mapper;

import com.example.tenant_service.dto.TenantVehicleDTO;
import com.example.tenant_service.dto.request.TenantVehicleRequest;
import com.example.tenant_service.entity.TenantVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TenantVehicleMapper {
    TenantVehicle toTenantVehicle(TenantVehicleRequest request);
    @Mapping(source = "vehicleId", target = "id")
    TenantVehicleDTO toTenantVehicleDTO(TenantVehicle tenantVehicle);
}
