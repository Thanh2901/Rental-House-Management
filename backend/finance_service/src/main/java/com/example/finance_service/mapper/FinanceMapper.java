package com.example.finance_service.mapper;

import com.example.finance_service.dto.FinanceDTO;
import com.example.finance_service.dto.request.FinanceRequest;
import com.example.finance_service.entity.Finance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FinanceMapper {
    FinanceDTO toFinanceDTO(Finance finance);
    Finance toFinance(FinanceRequest request);
}
