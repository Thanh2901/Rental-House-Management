package com.example.room_service.controller;

import com.example.room_service.dto.RoomTypeDTO;
import com.example.room_service.service.RoomTypeService;
import com.example.room_service.service.RoomTypeServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomtype")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoomTypeController {
    RoomTypeService roomTypeService;

    @PostMapping("/add")
    public ResponseEntity<RoomTypeDTO> addRoomType(@RequestBody RoomTypeDTO roomType) {
        return ResponseEntity.ok(roomTypeService.createRoomType(roomType));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<RoomTypeDTO>> getAllRoomTypes() {
        return ResponseEntity.ok(roomTypeService.getAllRoomTypes());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RoomTypeDTO> getRoomTypeById(@PathVariable long id) {
        return ResponseEntity.ok(roomTypeService.getRoomTypeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomTypeDTO> updateRoomType(@PathVariable long id, @RequestBody RoomTypeDTO roomType) {
        return ResponseEntity.ok(roomTypeService.updateRoomType(id, roomType));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoomType(@PathVariable long id) {
        roomTypeService.deleteRoomType(id);
        return ResponseEntity.ok("Deleted room type with id " + id);
    }
}
