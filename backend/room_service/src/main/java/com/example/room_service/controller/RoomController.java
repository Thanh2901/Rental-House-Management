package com.example.room_service.controller;

import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.dto.request.RoomRequest;
import com.example.room_service.dto.response.RoomResponse;
import com.example.room_service.entity.Room;
import com.example.room_service.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<RoomResponse> addRoom(@RequestBody RoomRequest request) {
        return ResponseEntity.ok(roomService.createRoom(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<RoomResponse>> getListRoom() {
        return ResponseEntity.ok(roomService.getListRoom());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable String id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomResponse> updateRoom(@PathVariable String id, @RequestBody RoomRequest request) {
        return ResponseEntity.ok(roomService.updateRoomById(id, request));
    }
}
