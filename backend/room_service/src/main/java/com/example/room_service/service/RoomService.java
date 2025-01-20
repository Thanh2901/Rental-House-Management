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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private AssetMapper assetMapper;
    @Autowired
    private AssetService assetService;
    @Autowired
    private AssetRepository assetRepository;

    public RoomDTO createRoom(RoomRequest request) {
        RoomType roomType = roomTypeRepository.findById(request.getRoomTypeId()).orElseThrow(() -> new RuntimeException("Room type not found"));
        Room room = roomMapper.toRoom(request);
        room.setRoomType(roomType);
        roomRepository.save(room);
        return roomMapper.toRoomDTO(room);
    }
}