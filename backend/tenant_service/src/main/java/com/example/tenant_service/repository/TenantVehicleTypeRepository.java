package com.example.tenant_service.repository;

import com.example.tenant_service.entity.TenantVehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantVehicleTypeRepository extends JpaRepository<TenantVehicleType, Long> {
}
