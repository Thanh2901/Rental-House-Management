package com.example.room_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "asset")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "room_id")
    Room room;
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "condition_id")
    Condition condition;
    String assetType;
    String assetName;
    LocalDateTime ownerShipDate;
    LocalDateTime upgradeDate;
    String imagePath;
}
