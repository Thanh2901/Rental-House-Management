package com.example.finance_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RoomRequest {
    double floorArea;
    double rentalPrice;
    int maximumOccupancy;
    long roomTypeId;
    boolean roomStatus;
    List<AssetRequest> facilities;
}

