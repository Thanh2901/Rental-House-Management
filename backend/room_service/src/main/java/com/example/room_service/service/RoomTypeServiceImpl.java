package com.example.room_service.service;

import com.example.room_service.dto.RoomTypeDTO;
import com.example.room_service.entity.RoomType;
import com.example.room_service.mapper.RoomTypeMapper;
import com.example.room_service.repository.RoomTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {
    RoomTypeRepository roomTypeRepository;
    RoomTypeMapper roomTypeMapper;

    public RoomTypeDTO createRoomType(RoomTypeDTO roomTypeDTO) {
        RoomType roomType = roomTypeMapper.toRoomType(roomTypeDTO);
        roomTypeRepository.save(roomType);
        return roomTypeMapper.toRoomTypeDTO(roomType);
    }

    public List<RoomTypeDTO> getAllRoomTypes() {
        return roomTypeRepository.findAll().stream().map(roomTypeMapper::toRoomTypeDTO).toList();
    }

    public RoomTypeDTO getRoomTypeById(long id) {
        return roomTypeMapper.toRoomTypeDTO(roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Room type not found")));
    }

    public RoomTypeDTO updateRoomType(long id, RoomTypeDTO roomTypeDTO) {
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Room type not found"));
        roomTypeRepository.save(roomType);
        return roomTypeMapper.toRoomTypeDTO(roomType);
    }

    public void deleteRoomType(long id) {
        roomTypeRepository.deleteById(id);
    }
}
