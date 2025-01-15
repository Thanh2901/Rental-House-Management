package com.example.tenant_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositRequest {
    double depositAmount;
    LocalDateTime depositDate;
    int tenantId;
}