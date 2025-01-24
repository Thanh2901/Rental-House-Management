package com.example.room_service.service;

import com.example.room_service.dto.ConditionDTO;
import com.example.room_service.entity.Condition;
import com.example.room_service.mapper.ConditionMapper;
import com.example.room_service.repository.ConditionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {
     ConditionRepository conditionRepository;
     ConditionMapper conditionMapper;

    public ConditionDTO createCondition(ConditionDTO conditionDTO) {
        Condition condition = conditionMapper.toCondition(conditionDTO);
        conditionRepository.save(condition);
        return conditionMapper.toConditionDTO(condition);
    }

    public List<ConditionDTO> getAllConditions() {
        return conditionRepository.findAll().stream().map(conditionMapper::toConditionDTO).toList();
    }

    public ConditionDTO getConditionById(long id) {
        return conditionMapper.toConditionDTO(conditionRepository.findById(id).orElseThrow(() -> new RuntimeException("No condition found with id " + id)));
    }

    public ConditionDTO updateCondition(long id, ConditionDTO conditionDTO) {
        Condition condition = conditionRepository.findById(id).orElseThrow(() -> new RuntimeException("No condition found with id " + id));
        conditionMapper.updateCondition(condition, conditionDTO);
        conditionRepository.save(condition);
        return conditionMapper.toConditionDTO(condition);
    }

    public void deleteCondition(long id) {
        conditionRepository.deleteById(id);
    }
}
