package com.example.finance_service.client;

import com.example.finance_service.dto.TenantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tenant-service")
public interface TenantClient {
    @PostMapping("/add")
    TenantDTO addTenant(@RequestBody TenantDTO tenantDTO);
    @GetMapping("/get/{id}")
    TenantDTO getTenantById(@PathVariable int id);
}
