package com.example.tenant_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tenant")
@Entity
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tenantId;
    String fullName;
    String phoneNumber;
    String idCardPassport;
    LocalDateTime rentalStartDate;
}
