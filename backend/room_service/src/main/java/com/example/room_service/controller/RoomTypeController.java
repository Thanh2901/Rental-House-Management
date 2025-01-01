package com.example.room_service.controller;

import com.example.room_service.dto.request.RoomTypeRequest;
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
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomTypeRequest request) {
        return ResponseEntity.ok(roomTypeService.createRoomType(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<RoomType>> getAllRoomTypes() {
        return ResponseEntity.ok(roomTypeService.getAllRoomTypes());
    }

    @GetMapping("/get/{roomTypeId}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable long roomTypeId) {
        return ResponseEntity.ok(roomTypeService.getRoomTypeById(roomTypeId));
    }

    @PutMapping("/update/{roomTypeId}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable long roomTypeId, @RequestBody RoomTypeRequest request) {
        return ResponseEntity.ok(roomTypeService.updateRoomType(roomTypeId, request));
    }

    @DeleteMapping("/delete/{roomTypeId}")
    public ResponseEntity<String> deleteRoomType(@PathVariable long roomTypeId) {
        roomTypeService.deleteRoomType(roomTypeId);
        return ResponseEntity.ok("Deleted room type with id " + roomTypeId);
    }
}
