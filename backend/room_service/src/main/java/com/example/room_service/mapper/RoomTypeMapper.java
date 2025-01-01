package com.example.room_service.mapper;

import com.example.room_service.dto.request.RoomTypeRequest;
import com.example.room_service.entity.RoomType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {
    RoomType toRoomType(RoomTypeRequest request);
    RoomType updateRoomType(@MappingTarget RoomType roomType, RoomTypeRequest request);
}
