package com.example.finance_service.mapper;

import com.example.finance_service.dto.InvoiceDTO;
import com.example.finance_service.dto.TenantDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    TenantDTO toTenantDTO(InvoiceDTO invoiceDTO);
}
