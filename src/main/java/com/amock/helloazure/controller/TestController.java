package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController handles basic test endpoints for the HelloAzure application.
 * This controller provides simple health check and test functionalities.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * GET endpoint for a basic health check.
     * Returns a success message to verify the controller is operational.
     *
     * @return ResponseEntity containing a success message
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        // Business logic: Simple string return for health verification
        String message = "TestController is healthy and running!";
        return ResponseEntity.ok(message);
    }

    /**
     * GET endpoint for a test operation.
     * Demonstrates basic API response handling.
     *
     * @return ResponseEntity containing a test message
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        // Business logic: Fixed response for testing purposes
        // Edge case: No parameters, always returns the same value
        String message = "Hello from TestController in HelloAzure!";
        return ResponseEntity.ok(message);
    }

    /**
     * GET endpoint that simulates an error scenario for testing error handling.
     * This is for demonstration; in production, handle errors gracefully.
     *
     * @return ResponseEntity with an error message (HTTP 500 for simulation)
     */
    @GetMapping("/error")
    public ResponseEntity<String> simulateError() {
        try {
            // Simulate potential runtime exception for error handling test
            if (true) { // Placeholder for edge case triggering error
                throw new RuntimeException("Simulated error for testing");
            }
            return ResponseEntity.ok("No error");
        } catch (Exception e) {
            // Proper error handling: Log and return error response
            // In real app, use logging framework like SLF4J
            return ResponseEntity.internalServerError().body("Error occurred: " + e.getMessage());
        }
    }
}