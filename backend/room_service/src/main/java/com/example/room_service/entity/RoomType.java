package com.example.room_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "room_type")
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String type;
}
