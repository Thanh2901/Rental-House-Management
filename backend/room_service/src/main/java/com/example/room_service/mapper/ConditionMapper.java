package com.example.room_service.mapper;

import com.example.room_service.dto.ConditionDTO;
import com.example.room_service.entity.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConditionMapper {
    Condition toCondition(ConditionDTO request);
    ConditionDTO toConditionDTO(Condition condition);
    Condition updateCondition(@MappingTarget Condition condition, ConditionDTO conditionDTO);
}
