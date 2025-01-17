package com.example.finance_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetRequest {
    long conditionId;
    String assetType;
    String assetName;
    LocalDateTime ownerShipDate;
    LocalDateTime upgradeDate;
    String imagePath;
}
