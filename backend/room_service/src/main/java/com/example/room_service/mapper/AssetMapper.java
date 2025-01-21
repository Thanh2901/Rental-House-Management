package com.example.room_service.mapper;

import com.example.room_service.dto.AssetDTO;
import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.entity.Asset;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AssetMapper {
    Asset toAsset(AssetRequest request);
    AssetDTO toAssetDTO(Asset asset);
    void updateAsset(@MappingTarget Asset asset, AssetRequest request);
}
