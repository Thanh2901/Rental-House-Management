package com.example.tenant_service.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tenant_vehicle_type")
public class TenantVehicleType {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;
    String type;
}
