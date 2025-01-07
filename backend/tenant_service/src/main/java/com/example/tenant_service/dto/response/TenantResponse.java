package com.example.tenant_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantResponse {
    int id;
    String fullName;
    String phoneNumber;
    String idCardPassport;
    LocalDateTime rentalStartDate;
}
