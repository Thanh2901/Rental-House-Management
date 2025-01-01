package com.example.tenant_service.controller;

import com.example.tenant_service.dto.TenantDTO;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    private TenantService tenantService;
    @PostMapping("/add")
    public ResponseEntity<Tenant> addTenant(@RequestBody TenantDTO tenantDTO){
        return ResponseEntity.ok(tenantService.createTenant(tenantDTO));
    }
}
