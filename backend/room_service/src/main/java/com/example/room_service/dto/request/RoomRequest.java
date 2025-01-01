package com.example.room_service.dto.request;

import com.example.room_service.entity.RoomType;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RoomRequest {
    double floorArea;
    double rentalPrice;
    int maximumOccupancy;
    int roomTypeId;
    boolean roomStatus;
    List<AssetRequest> facilities;
}

