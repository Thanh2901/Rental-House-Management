package com.example.tenant_service.mapper;


import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.dto.response.DepositResponse;
import com.example.tenant_service.entity.Deposit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepositMapper {
    Deposit toDeposit(DepositRequest depositRequest);
    Deposit updateDeposit(@MappingTarget Deposit deposit, DepositRequest request);
    DepositResponse toDepositResponse(Deposit deposit);
}
