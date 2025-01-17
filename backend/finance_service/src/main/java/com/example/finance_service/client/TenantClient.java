package com.example.finance_service.client;

import com.example.finance_service.dto.TenantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tenant-service", url = "http://localhost:8089/tenant/")
public interface TenantClient {
    @PostMapping("/add")
    void addTenant(@RequestBody TenantDTO tenantDTO);
}
