package com.example.finance_service.mapper;

import com.example.finance_service.dto.InvoiceDTO;
import com.example.finance_service.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceDTO toInvoiceDTO(Invoice invoice);
    Invoice toInvoice(InvoiceDTO invoiceDTO);
    void updateInvoice(@MappingTarget Invoice invoice, InvoiceDTO invoiceDTO);
}
