package com.example.finance_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinanceDTO {
    InvoiceDTO invoice;
    String type;
    Double amount;
    String description;
    LocalDateTime created_at;
}
