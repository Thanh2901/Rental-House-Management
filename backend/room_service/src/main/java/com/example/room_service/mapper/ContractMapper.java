package com.example.room_service.mapper;

import com.example.room_service.dto.ContractDTO;
import com.example.room_service.dto.request.ContractRequest;
import com.example.room_service.entity.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractDTO toContractDTO(Contract contract);
    Contract toContract(ContractRequest request);
    void updateContract(@MappingTarget Contract contract, ContractRequest request);
}
