package com.amock.helloazure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        // This endpoint provides a simple test response
        // No deprecated APIs used; compatible with Java 11+ and modern Spring Boot
        return ResponseEntity.ok("Test endpoint is working correctly after Java upgrade refactoring.");
    }

    // Additional methods can be added here if needed, but maintaining minimal changes
    // Error handling: Spring Boot's default exception handling is sufficient for this simple case
    // Edge cases: Empty request handled by default mapping
}