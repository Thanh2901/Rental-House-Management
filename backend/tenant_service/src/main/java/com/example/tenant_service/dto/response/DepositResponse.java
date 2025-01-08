package com.example.tenant_service.dto.response;

import com.example.tenant_service.entity.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositResponse {
    String id;
    Tenant tenant;
    double depositAmount;
    LocalDateTime depositDate;
}
