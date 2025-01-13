package com.example.room_service.service;

import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.dto.request.RoomRequest;
import com.example.room_service.dto.response.AssetResponse;
import com.example.room_service.dto.response.RoomResponse;
import com.example.room_service.entity.Asset;
import com.example.room_service.entity.Room;
import com.example.room_service.entity.RoomType;
import com.example.room_service.mapper.AssetMapper;
import com.example.room_service.mapper.RoomMapper;
import com.example.room_service.mapper.RoomTypeMapper;
import com.example.room_service.repository.AssetRepository;
import com.example.room_service.repository.RoomRepository;
import com.example.room_service.repository.RoomTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public RoomResponse createRoom(RoomRequest roomRequest) {
        RoomType roomType = roomTypeRepository.findById(roomRequest.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("Room type not found"));

        Room room = roomMapper.toRoom(roomRequest);
        room.setRoomType(roomType);

        // Tạo danh sách Asset từ danh sách AssetRequest trong RoomRequest
        List<Asset> assets = roomRequest.getFacilities().stream()
                .map(assetRequest -> assetService.createAssetForRoom(assetRequest))
                .collect(Collectors.toList());

        room.setFacilities(assets);

        room = roomRepository.save(room);

        if (room.getId() != null) {
            List<Asset> assetList = room.getFacilities();
            for (Asset asset : assetList) {
                asset.setRoom(room);
                assetRepository.save(asset);
            }
        }

        List<AssetResponse> assetResponses = room.getFacilities().stream()
                .map(assetMapper::toAssetResponse)
                .collect(Collectors.toList());

        RoomResponse roomResponse = roomMapper.toRoomResponse(room);
        roomResponse.setFacilities(assetResponses);

        return roomResponse;
    }

    public List<RoomResponse> getListRoom() {
        return roomRepository.findAll().stream().map(roomMapper::toRoomResponse).toList();
    }

    public RoomResponse getRoomById(String id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        return roomMapper.toRoomResponse(room);
    }

//    public RoomResponse updateRoomById(String id, RoomRequest request) {
//        Room room = roomRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Room not found"));
//
//        RoomType roomType = roomTypeRepository.findById(request.getRoomTypeId())
//                .orElseThrow(() -> new RuntimeException("Room type not found"));
//        room.setRoomType(roomType);
//
//        // Create new facilities list
//        List<Asset> updatedAssets = new ArrayList<>();
//        for (AssetRequest assetRequest : request.getFacilities()) {
//            for (Asset asset : room.getFacilities()) {
//                Asset newAsset = assetService.updateAssetForRoom(asset.getId(), assetRequest);
//                updatedAssets.add(newAsset);
//                assetRepository.save(newAsset);
//            }
//        }
//
//        room.setFacilities(updatedAssets);
//        room = roomMapper.updateRoom(room, request);
//        room = roomRepository.save(room);
//
//        List<AssetResponse> assetResponses = room.getFacilities().stream()
//                .map(assetMapper::toAssetResponse)
//                .collect(Collectors.toList());
//
//        RoomResponse roomResponse = roomMapper.toRoomResponse(room);
//        roomResponse.setFacilities(assetResponses);
//        return roomResponse;
//    }

    public RoomResponse updateRoomById(String id, RoomRequest request) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        RoomType roomType = roomTypeRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("Room type not found"));
        room.setRoomType(roomType);

        List<Asset> facilities = room.getFacilities();
        for (int i = 0; i < request.getFacilities().size(); i++) {
            AssetRequest assetRequest = request.getFacilities().get(i);
            Asset asset = facilities.get(i);
            assetService.updateAssetForRoom(asset.getId(), assetRequest);
        }

        room = roomMapper.updateRoom(room, request);
        room = roomRepository.save(room);

        List<AssetResponse> assetResponses = room.getFacilities().stream()
                .map(assetMapper::toAssetResponse)
                .collect(Collectors.toList());

        RoomResponse roomResponse = roomMapper.toRoomResponse(room);
        roomResponse.setFacilities(assetResponses);
        return roomResponse;
    }

}