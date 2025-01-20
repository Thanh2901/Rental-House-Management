package com.example.room_service.controller;

import com.example.room_service.dto.ConditionDTO;
import com.example.room_service.entity.Condition;
import com.example.room_service.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condition")
public class ConditionController {
    @Autowired
    private ConditionService conditionService;

    @PostMapping("/add")
    public ResponseEntity<ConditionDTO> addCondition(@RequestBody ConditionDTO conditionDTO) {
        return ResponseEntity.ok(conditionService.createCondition(conditionDTO));
    }
}
