package com.example.tenant_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tenant_vehicle" )
@Entity
public class TenantVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vehicleId;
    String licensePlate;
    String vehicleType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenantId")
    Tenant tenantId;
}
