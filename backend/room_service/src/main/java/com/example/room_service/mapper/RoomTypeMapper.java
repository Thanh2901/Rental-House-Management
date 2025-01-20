package com.example.room_service.mapper;

import com.example.room_service.dto.RoomTypeDTO;
import com.example.room_service.entity.RoomType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {
    RoomType toRoomType(RoomTypeDTO roomTypeDTO);
    RoomTypeDTO toRoomTypeDTO(RoomType roomType);
    RoomType updateRoomType(@MappingTarget RoomType roomType, RoomTypeDTO roomTypeDTO);
}
