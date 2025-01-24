package com.example.room_service.service;

import com.example.room_service.dto.RoomDTO;
import com.example.room_service.dto.request.RoomRequest;

import java.util.List;

public interface RoomService {
    RoomDTO createRoom(RoomRequest request);
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(String id);
    RoomDTO updateRoom(String id, RoomRequest request);
    void deleteRoom(String id);
}
