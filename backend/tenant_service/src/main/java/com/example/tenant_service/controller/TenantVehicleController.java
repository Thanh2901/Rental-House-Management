package com.example.tenant_service.controller;

import com.example.tenant_service.dto.request.TenantVehicleRequest;
import com.example.tenant_service.dto.response.TenantVehicleResponse;
import com.example.tenant_service.entity.TenantVehicle;
import com.example.tenant_service.repository.TenantVehicleRepository;
import com.example.tenant_service.service.TenantVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class TenantVehicleController {

    @Autowired
    private TenantVehicleRepository tenantVehicleRepository;

    @Autowired
    private TenantVehicleService tenantVehicleService;

    @PostMapping("/add")
    public ResponseEntity<TenantVehicle> addTenantVehicle(@RequestBody TenantVehicleRequest request){
        return ResponseEntity.ok(tenantVehicleService.createTenantVehicle(request));
    }

    @GetMapping("/get/{vehicleId}")
    public ResponseEntity<TenantVehicleResponse> getTenantVehicleById(@PathVariable int vehicleId){
        return ResponseEntity.ok(tenantVehicleService.getVehicleById(vehicleId));
    }

    @DeleteMapping("/delete/{tenantVehicleId}")
    public ResponseEntity<String> deleteTenantVehicle(@PathVariable int tenantVehicleId){
            tenantVehicleService.deleteTenantVehicle(tenantVehicleId);
            return ResponseEntity.ok("Tenant vehicle deleted successfully");
    }

}
