package com.example.room_service.service;

import com.example.room_service.dto.RoomTypeDTO;

import java.util.List;

public interface RoomTypeService {
    RoomTypeDTO createRoomType(RoomTypeDTO roomTypeDTO);
    List<RoomTypeDTO> getAllRoomTypes();
    RoomTypeDTO getRoomTypeById(long id);
    RoomTypeDTO updateRoomType(long id, RoomTypeDTO roomTypeDTO);
    void deleteRoomType(long id);
}
