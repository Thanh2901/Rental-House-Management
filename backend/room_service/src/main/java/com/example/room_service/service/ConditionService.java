package com.example.room_service.service;

import com.example.room_service.dto.ConditionDTO;
import com.example.room_service.entity.Condition;
import com.example.room_service.mapper.ConditionMapper;
import com.example.room_service.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService {
    @Autowired
    private ConditionRepository conditionRepository;
    @Autowired
    private ConditionMapper conditionMapper;

    public ConditionDTO createCondition(ConditionDTO conditionDTO) {
        Condition condition = conditionMapper.toCondition(conditionDTO);
        conditionRepository.save(condition);
        return conditionMapper.toConditionDTO(condition);
    }
}
