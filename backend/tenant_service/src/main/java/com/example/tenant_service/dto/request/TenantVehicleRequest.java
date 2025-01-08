package com.example.tenant_service.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantVehicleRequest {
    String licensePlate;
    Long vehicleTypeId;
    int tenantId;
}
