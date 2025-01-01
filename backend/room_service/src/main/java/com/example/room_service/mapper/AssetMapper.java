package com.example.room_service.mapper;

import com.example.room_service.dto.request.AssetRequest;
import com.example.room_service.dto.response.AssetResponse;
import com.example.room_service.entity.Asset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssetMapper {
    Asset toAsset(AssetRequest request);
    @Mapping(target = "roomId", source = "room.id")
    AssetResponse toAssetResponse(Asset asset);
}
