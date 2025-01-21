package com.example.room_service.dto;

import com.example.room_service.entity.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContractDTO {
    String id;
    int tenant_id;
    LocalDateTime contract_date;
    LocalDateTime start_date;
    LocalDateTime end_date;
    String term_condition;
}
