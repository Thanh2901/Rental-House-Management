package com.example.room_service.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContractRequest {
    String roomId;
    int tenant_id;
    LocalDateTime contract_date;
    LocalDateTime start_date;
    LocalDateTime end_date;
    String term_condition;
}
