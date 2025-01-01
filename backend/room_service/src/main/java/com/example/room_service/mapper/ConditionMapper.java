package com.example.room_service.mapper;

import com.example.room_service.dto.request.ConditionRequest;
import com.example.room_service.entity.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConditionMapper {
    Condition toCondition(ConditionRequest request);
    Condition updateCondition(@MappingTarget Condition condition, ConditionRequest request);
}
