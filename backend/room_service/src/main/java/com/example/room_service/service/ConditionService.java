package com.example.room_service.service;

import com.example.room_service.dto.request.ConditionRequest;
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

    public Condition createCondition(ConditionRequest request) {
        Condition condition = conditionMapper.toCondition(request);
        return conditionRepository.save(condition);
    }

    public List<Condition> getAllConditions() {
        return conditionRepository.findAll();
    }

    public Condition getConditionById(Long id) {
        return conditionRepository.findById(id).orElseThrow(() -> new RuntimeException("condition not found"));
    }

    public Condition updateCondition(Long id, ConditionRequest request) {
        Condition condition = conditionRepository.findById(id).orElseThrow(() -> new RuntimeException("condition not found"));
        condition = conditionMapper.updateCondition(condition, request);
        return conditionRepository.save(condition);
    }

    public void deleteCondition(Long id) {
        conditionRepository.deleteById(id);
    }
}
