package com.example.tenant_service.dto.response;


import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.entity.TenantVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantVehicleResponse {
    int id;
    String licensePlate;
    TenantVehicleType tenantVehicleType;
    Tenant tenant;
}
