package com.example.room_service.controller;

import com.example.room_service.dto.ConditionDTO;
import com.example.room_service.service.ConditionService;
import com.example.room_service.service.ConditionServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condition")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ConditionController {
    ConditionService conditionService;

    @PostMapping("/add")
    public ResponseEntity<ConditionDTO> addCondition(@RequestBody ConditionDTO conditionDTO) {
        return ResponseEntity.ok(conditionService.createCondition(conditionDTO));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<ConditionDTO>> getConditionList() {
        return ResponseEntity.ok(conditionService.getAllConditions());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ConditionDTO> getConditionById(@PathVariable long id) {
        return ResponseEntity.ok(conditionService.getConditionById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConditionDTO> updateCondition(@PathVariable long id, @RequestBody ConditionDTO conditionDTO) {
        return ResponseEntity.ok(conditionService.updateCondition(id, conditionDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCondition(@PathVariable long id) {
        conditionService.deleteCondition(id);
        return ResponseEntity.ok("Deleted condition with id " + id);
    }
}
