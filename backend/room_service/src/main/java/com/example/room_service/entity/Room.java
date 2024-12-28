package com.example.room_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String roomId;
    double floorArea;
    double rentalPrice;
    int maximumOccupancy;
    String roomType;
    boolean roomStatus;
    @OneToMany(mappedBy = "roomId", fetch = FetchType.EAGER, orphanRemoval = true)
    List<Asset> facilities;
}
