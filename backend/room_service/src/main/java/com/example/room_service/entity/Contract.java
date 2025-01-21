package com.example.room_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "contract")
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @ManyToOne
            @JoinColumn(name = "room_id")
    Room room;
    int tenant_id;
    LocalDateTime contract_date;
    LocalDateTime start_date;
    LocalDateTime end_date;
    String term_condition;
}
