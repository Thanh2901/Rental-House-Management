package com.example.tenant_service.dto;

import com.example.tenant_service.entity.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositDTO {
    String id;
    double depositAmount;
    LocalDateTime depositDate;
}
