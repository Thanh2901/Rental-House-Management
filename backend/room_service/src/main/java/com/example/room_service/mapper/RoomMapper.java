package com.example.room_service.mapper;

import com.example.room_service.dto.RoomDTO;
import com.example.room_service.dto.request.RoomRequest;
import com.example.room_service.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomRequest request);
    RoomDTO toRoomDTO(Room room);
    Room updateRoom(@MappingTarget Room room, RoomRequest request);
}
