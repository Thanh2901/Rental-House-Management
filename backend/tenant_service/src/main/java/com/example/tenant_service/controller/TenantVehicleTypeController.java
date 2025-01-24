package com.example.tenant_service.controller;


import com.example.tenant_service.dto.TenantVehicleTypeDTO;
import com.example.tenant_service.entity.TenantVehicleType;
import com.example.tenant_service.service.TenantVehicleTypeService;
import com.example.tenant_service.service.TenantVehicleTypeServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicleType")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TenantVehicleTypeController {
    TenantVehicleTypeService tenantVehicleTypeService;

    @PostMapping("/add")
    public ResponseEntity<TenantVehicleTypeDTO> createVehicleType(@RequestBody TenantVehicleType request){
        return ResponseEntity.ok(tenantVehicleTypeService.createVehicleType(request));
    }

    @GetMapping("/get/list")
    public ResponseEntity<List<TenantVehicleTypeDTO>> getAllVehicleTypes(){
        return ResponseEntity.ok(tenantVehicleTypeService.getAllTenantVehicleType());
    }

    @GetMapping("get/{vehicleTypeId}")
    public ResponseEntity<TenantVehicleTypeDTO> getVehicleTypeById(@PathVariable Long vehicleTypeId){
        return ResponseEntity.ok(tenantVehicleTypeService.getTenantVehicleTypeById(vehicleTypeId));
    }

    @PutMapping("/update/{vehicleTypeId}")
    public ResponseEntity<TenantVehicleTypeDTO> updateVehicleTypeById(@PathVariable Long vehicleTypeId, @RequestBody TenantVehicleType request){
        return ResponseEntity.ok(tenantVehicleTypeService.updateTenantVehicleType(vehicleTypeId, request));
    }

    @DeleteMapping("/delete/{vehicleTypeId}")
    public ResponseEntity<String> deleteVehicleTypeById(@PathVariable Long vehicleTypeId){
        tenantVehicleTypeService.deleteTenantVehicleType(vehicleTypeId);
        return ResponseEntity.ok("Vehicle type was deleted successfully");
    }
}
