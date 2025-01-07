package com.example.tenant_service.controller;

import com.example.tenant_service.dto.request.TenantRequest;
import com.example.tenant_service.dto.response.TenantResponse;
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
    public ResponseEntity<Tenant> addTenant(@RequestBody TenantRequest tenantDTO){
        return ResponseEntity.ok(tenantService.createTenant(tenantDTO));
    }

    @GetMapping("/get/{tenantId}")
    public ResponseEntity<TenantResponse> getTenantById(@RequestBody TenantRequest tenantRequest, @PathVariable int tenantId){
        return ResponseEntity.ok(tenantService.getTenantById(tenantId));
    }

    @DeleteMapping("/delete/{tenantId}")
    public ResponseEntity<String> deleteTenantById(@PathVariable int tenantId){
        tenantService.deleteTenant(tenantId);
        return ResponseEntity.ok("tenant deleted successfully");
    }
}
