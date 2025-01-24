package com.example.room_service.service;

import com.example.room_service.dto.ConditionDTO;

import java.util.List;

public interface ConditionService {
    ConditionDTO createCondition(ConditionDTO conditionDTO);
    List<ConditionDTO> getAllConditions();
    ConditionDTO getConditionById(long id);
    ConditionDTO updateCondition(long id, ConditionDTO conditionDTO);
    void deleteCondition(long id);
}
