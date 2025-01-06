package com.example.room_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Condition condition;
    String assetType;
    String assetName;
    LocalDateTime ownerShipDate;
    LocalDateTime upgradeDate;
    String imagePath;
}
