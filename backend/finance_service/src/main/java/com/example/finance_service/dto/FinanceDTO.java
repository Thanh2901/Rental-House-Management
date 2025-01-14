package com.example.finance_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinanceDTO {
    String id;
    String transaction_type;
    Double amount;
    String description;
    LocalDateTime created_at;
}
