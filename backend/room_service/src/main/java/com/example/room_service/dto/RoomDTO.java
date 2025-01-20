package com.example.room_service.dto;

import lombok.Data;

@Data
public class RoomDTO {
    String id;
    double floorArea;
    double rentalPrice;
    int maximumOccupancy;
    boolean roomStatus;
}
