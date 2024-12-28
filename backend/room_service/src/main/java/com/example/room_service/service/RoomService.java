package com.example.room_service.service;

import com.example.room_service.dto.RoomRequest;
import com.example.room_service.entity.Room;
import com.example.room_service.mapper.RoomMapper;
import com.example.room_service.mapper.RoomMapperMapstruct;
import com.example.room_service.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapperMapstruct roomMapper;

    public Room createRoom(RoomRequest request) {
        Room room  = roomMapper.toRoom(request);
        room = roomRepository.save(room);
        return room;
    }
    // 123
}
