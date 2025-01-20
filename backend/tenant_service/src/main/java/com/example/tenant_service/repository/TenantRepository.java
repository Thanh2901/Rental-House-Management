package com.example.tenant_service.repository;

import com.example.tenant_service.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    /*@Query()
    List<Invoice>*/
}
