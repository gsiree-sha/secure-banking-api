package com.sireesha.securebankingapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Health")
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Secure Banking API is running";
    }
}
