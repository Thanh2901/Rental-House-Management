package com.example.tenant_service.service;

import com.example.tenant_service.dto.TenantVehicleTypeDTO;
import com.example.tenant_service.entity.TenantVehicleType;
import com.example.tenant_service.mapper.TenantVehicleTypeMapper;
import com.example.tenant_service.repository.TenantRepository;
import com.example.tenant_service.repository.TenantVehicleTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TenantVehicleTypeServiceImpl implements TenantVehicleTypeService{
    TenantVehicleTypeRepository tenantVehicleTypeRepository;
    TenantVehicleTypeMapper tenantVehicleTypeMapper;
    TenantRepository tenantRepository;


    public TenantVehicleTypeDTO createVehicleType(TenantVehicleType tenantVehicleType){
        return tenantVehicleTypeMapper.toTenantVehicleTypeDTO(tenantVehicleTypeRepository.save(tenantVehicleType));
    }

    public List<TenantVehicleTypeDTO> getAllTenantVehicleType(){
        return tenantVehicleTypeRepository.findAll().stream().map(tenantVehicleTypeMapper::toTenantVehicleTypeDTO).collect(Collectors.toList());
    }

    public TenantVehicleTypeDTO getTenantVehicleTypeById(Long id){
        TenantVehicleType tenantVehicleType = tenantVehicleTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle type " + id + " not found"));
        return tenantVehicleTypeMapper.toTenantVehicleTypeDTO(tenantVehicleType);
    }


    public TenantVehicleTypeDTO updateTenantVehicleType(Long id, TenantVehicleType tenantVehicleType){
        TenantVehicleType updateTenantVehicleType = tenantVehicleTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle type " + id + " not found"));
        updateTenantVehicleType.setType(tenantVehicleType.getType());
        tenantVehicleTypeRepository.save(updateTenantVehicleType);
        return tenantVehicleTypeMapper.toTenantVehicleTypeDTO(updateTenantVehicleType);
    }

    public void deleteTenantVehicleType(Long id){
        tenantVehicleTypeRepository.deleteById(id);
    }
}
