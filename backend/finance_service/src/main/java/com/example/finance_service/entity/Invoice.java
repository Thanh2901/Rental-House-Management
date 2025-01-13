package com.example.finance_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "invoice")
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String tenant_id;
    String room_id;
    Double amount;
    String payment_method;
    LocalDate payment_date;
    LocalDate created_at;
}
