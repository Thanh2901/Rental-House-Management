package com.example.room_service.controller;

import com.example.room_service.dto.RoomTypeDTO;
import com.example.room_service.entity.RoomType;
import com.example.room_service.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomtype")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/add")
    public ResponseEntity<RoomTypeDTO> addRoomType(@RequestBody RoomTypeDTO roomType) {
        return ResponseEntity.ok(roomTypeService.createRoomType(roomType));
    }
}
