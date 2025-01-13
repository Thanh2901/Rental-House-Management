package com.example.finance_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceDTO {
    String tenant_id;
    String room_id;
    Double amount;
    String payment_method;
    LocalDate payment_date;
    LocalDate created_at;
}
