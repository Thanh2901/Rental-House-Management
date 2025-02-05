package com.example.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("tenant-route", r -> r.path("/tenant/**")
                        .filters(f -> f.stripPrefix(1)
                                .circuitBreaker(c -> c.setName("CircuitBeaker")
                                        .getFallbackUri()))
                        .uri("lb://tenant-service"))
                .route("finance-service", r -> r.path("/finance/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://finance-service"))
                .route("room-service", r -> r.path("/room/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://room-service"))
                .build();
    }

}
