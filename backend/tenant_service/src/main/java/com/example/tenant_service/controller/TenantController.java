package com.example.tenant_service.controller;

import com.example.tenant_service.dto.TenantDTO;
import com.example.tenant_service.entity.Tenant;
import com.example.tenant_service.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    private TenantService tenantService;
    @PostMapping("/add")
    public ResponseEntity<TenantDTO> addTenant(@RequestBody Tenant tenant){
        return ResponseEntity.ok(tenantService.createTenant(tenant));
    }

    @GetMapping("/get/{tenantId}")
    public ResponseEntity<TenantDTO> getTenantById(@PathVariable int tenantId){
        return ResponseEntity.ok(tenantService.getTenantById(tenantId));
    }

    @PutMapping("/update/{tenantId}")
    public ResponseEntity<TenantDTO> updateTenant(@PathVariable int tenantId, @RequestBody Tenant tenant){
        return ResponseEntity.ok(tenantService.updateTenant(tenantId, tenant));
    }
    @GetMapping("/tenants")
    public ResponseEntity<List<TenantDTO>> getAllTenant(){
        return ResponseEntity.ok(tenantService.getAllTenant());
    }
    @DeleteMapping("/delete/{tenantId}")
    public ResponseEntity<String> deleteTenantById(@PathVariable int tenantId){
        tenantService.deleteTenant(tenantId);
        return ResponseEntity.ok("tenant deleted successfully");
    }
}
