package com.example.room_service.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RoomRequest {
    private double floorArea;
    private double rentalPrice;
    private int maximumOccupancy;
    private String roomType;
    private boolean roomStatus;
}

