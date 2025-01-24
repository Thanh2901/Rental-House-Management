package com.example.tenant_service.controller;

import com.example.tenant_service.dto.TenantVehicleDTO;
import com.example.tenant_service.dto.request.TenantVehicleRequest;
import com.example.tenant_service.repository.TenantVehicleRepository;
import com.example.tenant_service.service.TenantVehicleService;
import com.example.tenant_service.service.TenantVehicleServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TenantVehicleController {
    TenantVehicleRepository tenantVehicleRepository;
    TenantVehicleService tenantVehicleService;

    @PostMapping("/add")
    public ResponseEntity<TenantVehicleDTO> addTenantVehicle(@RequestBody TenantVehicleRequest request){
        return ResponseEntity.ok(tenantVehicleService.createTenantVehicle(request));
    }

    @GetMapping("/get/{vehicleId}")
    public ResponseEntity<TenantVehicleDTO> getTenantVehicleById(@PathVariable int vehicleId){
        return ResponseEntity.ok(tenantVehicleService.getVehicleById(vehicleId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TenantVehicleDTO>> getAllVehicles(){
        return ResponseEntity.ok(tenantVehicleService.getAllVehicles());
    }

    @DeleteMapping("/delete/{tenantVehicleId}")
    public ResponseEntity<String> deleteTenantVehicle(@PathVariable int tenantVehicleId){
            tenantVehicleService.deleteTenantVehicle(tenantVehicleId);
            return ResponseEntity.ok("Tenant vehicle deleted successfully");
    }

}
