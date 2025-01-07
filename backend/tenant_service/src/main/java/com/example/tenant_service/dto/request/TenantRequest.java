package com.example.tenant_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TenantRequest {
    private String fullName;
    private String phoneNumber;
    private String idCardPassport;
    private LocalDateTime rentalStartDate;
}
