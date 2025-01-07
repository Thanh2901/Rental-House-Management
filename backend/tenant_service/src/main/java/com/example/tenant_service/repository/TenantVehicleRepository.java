package com.example.tenant_service.repository;

import com.example.tenant_service.entity.TenantVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantVehicleRepository extends JpaRepository<TenantVehicle, Integer> {
}
