package com.example.room_service.controller;

import com.example.room_service.dto.RoomDTO;
import com.example.room_service.dto.request.RoomRequest;
import com.example.room_service.service.RoomService;
import com.example.room_service.service.RoomServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/room")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoomController {
    RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<RoomDTO> addRoom(@RequestBody RoomRequest request) {
        return ResponseEntity.ok(roomService.createRoom(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<RoomDTO>> getRoomList() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable("id") String id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable("id") String id, @RequestBody RoomRequest request) {
        return ResponseEntity.ok(roomService.updateRoom(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") String id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok("Deleted room" + id);
    }
}
