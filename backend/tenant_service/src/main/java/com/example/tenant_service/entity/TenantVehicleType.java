package com.example.tenant_service.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tenant_vehicle_type")
public class TenantVehicleType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;
    String type;
}
