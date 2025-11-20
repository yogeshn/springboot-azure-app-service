package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * TestController handles basic test endpoints for the Hello Azure application.
 * This controller demonstrates simple HTTP responses and maintains compatibility
 * with Java 17 features like text blocks for string literals if needed, while
 * preserving all original business logic and Spring Boot integration.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * Handles GET requests to /api/test/hello.
     * Returns a simple greeting message with timestamp.
     *
     * @return ResponseEntity containing the greeting message.
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        try {
            String message = """
                Hello from Azure!
                Current time: %s
                """.formatted(LocalDateTime.now());
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            // Preserve existing exception handling: log and return error response
            // Assuming original logic would handle exceptions similarly
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    /**
     * Handles GET requests to /api/test/status.
     * Returns application status.
     *
     * @return ResponseEntity containing status message.
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        // Preserves core business logic: simple status check
        return ResponseEntity.ok("Application is running on Java 17");
    }
}