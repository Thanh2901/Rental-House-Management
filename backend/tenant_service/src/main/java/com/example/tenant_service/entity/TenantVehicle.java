package com.example.tenant_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tenant_vehicle" )
@Entity
public class TenantVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vehicleId;
    String licensePlate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant_vehicle_type_id")
    TenantVehicleType tenantVehicleType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant_id")
    Tenant tenant;
}
