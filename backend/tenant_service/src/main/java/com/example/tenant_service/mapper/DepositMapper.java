package com.example.tenant_service.mapper;


import com.example.tenant_service.dto.DepositDTO;
import com.example.tenant_service.dto.request.DepositRequest;
import com.example.tenant_service.entity.Deposit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepositMapper {
    Deposit toDeposit(DepositRequest depositRequest);
    @Mapping(source = "depositId", target = "id")
    DepositDTO toDepositDTO(Deposit deposit);
}
