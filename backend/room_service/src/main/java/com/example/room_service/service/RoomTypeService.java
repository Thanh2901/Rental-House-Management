package com.example.room_service.service;

import com.example.room_service.dto.request.RoomTypeRequest;
import com.example.room_service.entity.RoomType;
import com.example.room_service.mapper.RoomTypeMapper;
import com.example.room_service.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    public RoomType createRoomType(RoomTypeRequest request){
        RoomType roomType = roomTypeMapper.toRoomType(request);
        return roomTypeRepository.save(roomType);
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeById(Long id){
        return roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("room type not found"));
    }

    public RoomType updateRoomType(Long id, RoomTypeRequest request){
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("room type not found"));
        roomType = roomTypeMapper.updateRoomType(roomType, request);
        return roomTypeRepository.save(roomType);
    }

    public void deleteRoomType(Long id){
        roomTypeRepository.deleteById(id);
    }
}
