package com.example.tenant_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantDTO {
    int id;
    String fullName;
    String phoneNumber;
    String idCardPassport;
    LocalDateTime rentalStartDate;
}
