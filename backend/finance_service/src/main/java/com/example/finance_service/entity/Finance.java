package com.example.finance_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "finance")
@Data
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @ManyToOne
            @JoinColumn(name = "invoice_id")
    Invoice invoice;
    String type;
    Double amount;
    String description;
    LocalDateTime created_at;
}
