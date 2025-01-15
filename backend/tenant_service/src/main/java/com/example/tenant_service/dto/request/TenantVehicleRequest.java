package com.example.tenant_service.dto.request;

import com.example.tenant_service.entity.TenantVehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantVehicleRequest {
    String licensePlate;
    Long tenantVehicleTypeId;
    int tenantId;
}
