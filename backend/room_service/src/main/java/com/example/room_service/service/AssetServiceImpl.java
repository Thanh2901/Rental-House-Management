package com.example.room_service.service;

import com.example.room_service.dto.AssetDTO;
import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.entity.Asset;
import com.example.room_service.entity.Condition;
import com.example.room_service.entity.Room;
import com.example.room_service.mapper.AssetMapper;
import com.example.room_service.repository.AssetRepository;
import com.example.room_service.repository.ConditionRepository;
import com.example.room_service.repository.RoomRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AssetServiceImpl implements  AssetService {
     AssetRepository assetRepository;
     AssetMapper assetMapper;
     ConditionRepository conditionRepository;
     RoomRepository roomRepository;

    public AssetDTO createAsset(AssetRequest request) {
        Room room = roomRepository.findById(request.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        Condition condition = conditionRepository.findById(request.getConditionId()).orElseThrow(() -> new RuntimeException("Condition not found"));
        Asset asset = assetMapper.toAsset(request);
        asset.setRoom(room);
        asset.setCondition(condition);
        assetRepository.save(asset);
        return assetMapper.toAssetDTO(asset);
    }

    public List<AssetDTO> getAllAssets() {
        return assetRepository.findAll().stream().map(assetMapper::toAssetDTO).toList();
    }

    public AssetDTO getAssetById(String id) {
        return assetMapper.toAssetDTO(assetRepository.findById(id).orElseThrow(() -> new RuntimeException("Asset not found")));
    }

    public AssetDTO updateAsset(String id, AssetRequest request) {
        Asset asset = assetRepository.findById(id).orElseThrow(() -> new RuntimeException("Asset not found"));
        assetMapper.updateAsset(asset, request);
        assetRepository.save(asset);
        return assetMapper.toAssetDTO(asset);
    }

    public void deleteAsset(String id) {
        assetRepository.deleteById(id);
    }
}
