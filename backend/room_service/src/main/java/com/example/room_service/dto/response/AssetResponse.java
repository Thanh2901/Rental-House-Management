package com.example.room_service.dto.response;

import com.example.room_service.entity.Condition;
import com.example.room_service.entity.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetResponse {
    String id;
    Condition condition;
    @JsonIgnore
    Room room;
    String assetType;
    String assetName;
    LocalDateTime ownerShipDate;
    LocalDateTime upgradeDate;
    String imagePath;
}
