package com.example.tenant_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "tenant")
@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tenantId;
    // sau nho them account id
    // int account_id
    String fullName;
    String phoneNumber;
    String idCardPassport;
    LocalDateTime rentalStartDate;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    List<TenantVehicle> vehicles;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    List<Deposit> deposits;
}
