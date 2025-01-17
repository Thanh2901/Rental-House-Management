package com.example.finance_service.mapper;

import com.example.finance_service.dto.InvoiceDTO;
import com.example.finance_service.dto.TenantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    @Mapping(source = "tenant_id", target = "id")
    TenantDTO toTenantDTO(InvoiceDTO invoiceDTO);
}
