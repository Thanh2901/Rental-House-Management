package com.example.finance_service.entity;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    List<Finance> finances;
}
