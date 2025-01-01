package com.example.room_service.controller;

import com.example.room_service.dto.request.ConditionRequest;
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
    public ResponseEntity<Condition> addCondition(@RequestBody ConditionRequest request) {
        return ResponseEntity.ok(conditionService.createCondition(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<Condition>> getConditionList() {
        return ResponseEntity.ok(conditionService.getAllConditions());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Condition> getConditionById(@PathVariable("id") long id) {
        return ResponseEntity.ok(conditionService.getConditionById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Condition> updateCondition(@PathVariable("id") long id, @RequestBody ConditionRequest request) {
        return ResponseEntity.ok(conditionService.updateCondition(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCondition(@PathVariable("id") long id) {
        conditionService.deleteCondition(id);
        return ResponseEntity.ok("Deleted condition with id " + id);
    }
}
