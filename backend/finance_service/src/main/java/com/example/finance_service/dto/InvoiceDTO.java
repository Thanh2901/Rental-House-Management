package com.example.finance_service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class InvoiceDTO {
    String id;
    int tenant_id;
    String room_id;
    Double amount;
    String payment_method;
    LocalDate payment_date;
    LocalDate created_at;
    List<FinanceDTO> finances;
}
