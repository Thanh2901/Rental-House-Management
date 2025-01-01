package com.example.room_service.dto.response;

import com.example.room_service.entity.Asset;
import com.example.room_service.entity.RoomType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {
    String id;
    double floorArea;
    double rentalPrice;
    int maximumOccupancy;
    RoomType roomType;
    boolean roomStatus;
    List<AssetResponse> facilities;
}
