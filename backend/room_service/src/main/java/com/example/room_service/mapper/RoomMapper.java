package com.example.room_service.mapper;

import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.dto.request.ConditionRequest;
import com.example.room_service.dto.request.RoomRequest;
import com.example.room_service.dto.response.AssetResponse;
import com.example.room_service.dto.response.RoomResponse;
import com.example.room_service.entity.Asset;
import com.example.room_service.entity.Condition;
import com.example.room_service.entity.Room;
import com.example.room_service.entity.RoomType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomRequest request);
    RoomResponse toRoomResponse(Room room);
}
