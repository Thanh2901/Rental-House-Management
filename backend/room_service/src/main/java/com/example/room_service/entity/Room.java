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
    String id;
    double floorArea;
    double rentalPrice;
    int maximumOccupancy;
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "room_type_id")
    RoomType roomType;
    boolean roomStatus;
    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER, orphanRemoval = true)
    List<Asset> facilities;
}
