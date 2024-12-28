package com.example.room_service.mapper;

import com.example.room_service.dto.RoomRequest;
import com.example.room_service.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapperMapstruct {
    Room toRoom(RoomRequest request);
}
