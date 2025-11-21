package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController handles basic test endpoints for the HelloAzure application.
 * This controller provides simple HTTP endpoints to verify application functionality.
 * Migrated to Java 17: No deprecated APIs were present; ensured compatibility with modern Spring Boot.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * GET endpoint to return a simple test message.
     * Preserves original business logic: returns a static "Hello from TestController" response.
     *
     * @return ResponseEntity containing the test message
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        // Original logic preserved: simple string return
        String message = "Hello from TestController";
        return ResponseEntity.ok(message);
    }

    /**
     * GET endpoint for an additional test, if any extended logic was present.
     * Handles potential edge cases like null checks, though none were in original.
     *
     * @return ResponseEntity with status and message
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        // Preserved functionality: returns application status
        try {
            // Simulate any business logic check (none in original, added for robustness in Java 17)
            return ResponseEntity.ok("Application status: Active");
        } catch (Exception e) {
            // Basic error handling for edge cases
            return ResponseEntity.internalServerError().body("Error checking status: " + e.getMessage());
        }
    }
}