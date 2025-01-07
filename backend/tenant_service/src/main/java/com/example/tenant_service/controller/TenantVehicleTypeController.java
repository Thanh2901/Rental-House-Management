package com.example.tenant_service.controller;


import com.example.tenant_service.dto.request.TenantVehicleTypeRequest;
import com.example.tenant_service.dto.response.TenantVehicleTypeResponse;
import com.example.tenant_service.entity.TenantVehicleType;
import com.example.tenant_service.service.TenantVehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicleType")
public class TenantVehicleTypeController {
    @Autowired
    private TenantVehicleTypeService tenantVehicleTypeService;

    @PostMapping("/add")
    public ResponseEntity<TenantVehicleType> createVehicleType(@RequestBody TenantVehicleTypeRequest request){
        return ResponseEntity.ok(tenantVehicleTypeService.createVehicleType(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<TenantVehicleType>> getAllVehicleTypes(){
        return ResponseEntity.ok(tenantVehicleTypeService.getAllTenantVehicleType());
    }

    @GetMapping("get/{vehicleTypeId}")
    public ResponseEntity<TenantVehicleTypeResponse> getVehicleTypeById(@PathVariable Long vehicleTypeId){
        return ResponseEntity.ok(tenantVehicleTypeService.getTenantVehicleTypeById(vehicleTypeId));
    }

    @PutMapping("/update/{vehicleTypeId}")
    public ResponseEntity<TenantVehicleType> updateVehicleTypeById(@PathVariable Long vehicleTypeId, @RequestBody TenantVehicleTypeRequest request){
        return ResponseEntity.ok(tenantVehicleTypeService.updateTenantVehicleType(vehicleTypeId, request));
    }

    @DeleteMapping("/delete/{vehicleTypeId}")
    public ResponseEntity<String> deleteVehicleTypeById(@PathVariable Long vehicleTypeId){
        tenantVehicleTypeService.deleteTenantVehicleType(vehicleTypeId);
        return ResponseEntity.ok("Vehicle type was deleted successfully");
    }
}
