package com.example.room_service.dto;

import com.example.room_service.entity.Condition;
import com.example.room_service.entity.Room;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssetDTO {
    String id;
    String assetType;
    String assetName;
    LocalDateTime ownerShipDate;
    LocalDateTime upgradeDate;
    String imagePath;
}
