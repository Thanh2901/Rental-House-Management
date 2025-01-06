package com.example.room_service.service;

import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.dto.response.AssetResponse;
import com.example.room_service.entity.Asset;
import com.example.room_service.entity.Condition;
import com.example.room_service.entity.Room;
import com.example.room_service.mapper.AssetMapper;
import com.example.room_service.repository.AssetRepository;
import com.example.room_service.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private AssetMapper assetMapper;
    @Autowired
    private ConditionRepository conditionRepository;

    public Asset createAssetForRoom(AssetRequest request) {
        Condition condition = conditionRepository.findById(request.getConditionId()).orElseThrow(() -> new RuntimeException("condition not found"));
        Asset asset = assetMapper.toAsset(request);
        asset.setCondition(condition);
        return asset;
    }

    public Asset updateAssetForRoom(String id, AssetRequest request) {
        Asset asset = assetRepository.findById(id).orElseThrow(() -> new RuntimeException("asset not found"));
        Condition condition = conditionRepository.findById(request.getConditionId()).orElseThrow(() -> new RuntimeException("condition not found"));
        asset.setCondition(condition);
        assetMapper.updateAsset(asset, request);
        return asset;
    }
}
