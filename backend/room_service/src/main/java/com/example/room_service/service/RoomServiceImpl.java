package com.example.room_service.service;

import com.example.room_service.dto.RoomDTO;
import com.example.room_service.dto.request.RoomRequest;
import com.example.room_service.entity.Room;
import com.example.room_service.entity.RoomType;
import com.example.room_service.mapper.AssetMapper;
import com.example.room_service.mapper.RoomMapper;
import com.example.room_service.repository.AssetRepository;
import com.example.room_service.repository.RoomRepository;
import com.example.room_service.repository.RoomTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{
    RoomRepository roomRepository;
    RoomMapper roomMapper;
    RoomTypeRepository roomTypeRepository;

    public RoomDTO createRoom(RoomRequest request) {
        RoomType roomType = roomTypeRepository.findById(request.getRoomTypeId()).orElseThrow(() -> new RuntimeException("Room type not found"));
        Room room = roomMapper.toRoom(request);
        room.setRoomType(roomType);
        roomRepository.save(room);
        return roomMapper.toRoomDTO(room);
    }

    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll().stream().map(roomMapper::toRoomDTO).toList();
    }

    public RoomDTO getRoomById(String id) {
        return roomMapper.toRoomDTO(roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found")));
    }

    public RoomDTO updateRoom(String id, RoomRequest request) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        roomMapper.updateRoom(room, request);
        RoomType roomType = roomTypeRepository.findById(request.getRoomTypeId()).orElseThrow(() -> new RuntimeException("Room type not found"));
        room.setRoomType(roomType);
        roomRepository.save(room);
        return roomMapper.toRoomDTO(room);
    }

    public void deleteRoom(String id) {
        roomRepository.deleteById(id);
    }
}