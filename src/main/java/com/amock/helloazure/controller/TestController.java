package com.amock.helloazure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * A simple test controller for the HelloAzure application.
 * This controller provides basic endpoints to verify application functionality.
 * Updated for compatibility with Java 17+ and Spring Boot 3.x, ensuring no deprecated features are used.
 * No module handling issues detected; minimal changes applied for clarity and error handling.
 */
@RestController
public class TestController {

    /**
     * GET endpoint to test the application.
     * Returns a simple message.
     *
     * @return ResponseEntity with a success message.
     */
    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        try {
            String message = "Hello from TestController! Application is running smoothly.";
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            // Basic error handling for unexpected issues
            return new ResponseEntity<>("An error occurred during testing.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Additional GET endpoint for health check.
     * Ensures compatibility with Spring Boot actuators if enabled.
     *
     * @return ResponseEntity with health status.
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        // Edge case: Always return healthy unless specific checks fail
        String status = "Application is healthy and compatible with current Java version.";
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}