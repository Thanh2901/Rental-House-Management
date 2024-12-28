package com.example.room_service.mapper;

import com.example.room_service.dto.RoomRequest;
import com.example.room_service.entity.Asset;
import com.example.room_service.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

@Component
public class RoomMapper {
    @Autowired
    private ModelMapper modelMapper;

//    public Room toRoom(RoomRequest request) {
//        Room room = modelMapper.map(request, Room.class);
//        if (request.getFacilities() != null) {
//            room.setFacilities(
//                    request.getFacilities().stream()
//                            .map(assetDTO -> modelMapper.map(assetDTO, Asset.class))
//                            .collect(Collectors.toList())
//            );
//        }
//        return room;
//    }
}

