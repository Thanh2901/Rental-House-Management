package com.example.tenant_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "deposit")
@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int depositId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenantId")
    Tenant tenantId;
    double depositAmount;
    LocalDateTime depositDate;
}
