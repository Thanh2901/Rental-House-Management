package com.example.finance_service.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinanceRequest {
    String invoiceId;
    String transaction_type;
    Double amount;
    String description;
    LocalDateTime created_at;
}
