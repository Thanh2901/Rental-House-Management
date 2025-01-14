package com.example.finance_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "finance")
@Data
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    Invoice invoice;
    String transaction_type;
    Double amount;
    String description;
    LocalDateTime created_at;
}
