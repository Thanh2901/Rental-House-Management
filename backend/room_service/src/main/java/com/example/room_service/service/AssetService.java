package com.example.room_service.service;

import com.example.room_service.dto.AssetDTO;
import com.example.room_service.dto.request.AssetRequest;

import java.util.List;

public interface AssetService {
    AssetDTO createAsset(AssetRequest request);
    List<AssetDTO> getAllAssets();
    AssetDTO getAssetById(String id);
    AssetDTO updateAsset(String id, AssetRequest request);
    void deleteAsset(String id);
}
