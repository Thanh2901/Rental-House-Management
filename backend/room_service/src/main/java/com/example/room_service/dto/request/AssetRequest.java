package com.example.room_service.dto.request;

import com.example.room_service.entity.Condition;
import com.example.room_service.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetRequest {
    String roomId;
    Long conditionId;
    String assetType;
    String assetName;
    LocalDateTime ownerShipDate;
    LocalDateTime upgradeDate;
    String imagePath;
}
