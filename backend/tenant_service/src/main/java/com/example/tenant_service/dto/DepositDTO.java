package com.example.tenant_service.dto;

import com.example.tenant_service.entity.Tenant;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepositDTO {
    String id;
    double depositAmount;
    LocalDateTime depositDate;
}
