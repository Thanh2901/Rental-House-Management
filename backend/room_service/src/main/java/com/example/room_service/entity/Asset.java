package com.example.room_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asset")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String assetId;
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "roomId")
    Room roomId;
    String assetType;
    String assetName;
    String location;
    String condition;

}
