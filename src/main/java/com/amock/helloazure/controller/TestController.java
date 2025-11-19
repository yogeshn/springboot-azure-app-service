package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * TestController handles basic test endpoints for the HelloAzure application.
 * This controller has been updated to ensure compatibility with Java 17+ and Spring Boot 3.x.
 * Key changes include:
 * - Use of modern Java features like var and text blocks (if applicable).
 * - Added performance monitoring with timing.
 * - Improved error handling for runtime exceptions.
 * - Ensured no deprecated APIs are used that could cause startup failures.
 */
@RestController
public class TestController {

    /**
     * Simple test endpoint that returns a greeting message.
     * Includes basic performance timing to detect potential issues during Java upgrades.
     * @param name Optional name parameter for personalized greeting.
     * @return ResponseEntity with greeting message and execution time.
     */
    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> test(@RequestParam(required = false) String name) {
        Instant start = Instant.now();
        try {
            // Simulate some work that might highlight performance differences in JVM versions
            performSimulatedWork();

            String message = (name != null && !name.trim().isEmpty()) 
                ? "Hello, " + name + " from TestController!" 
                : "Hello from TestController!";

            Map<String, Object> response = new HashMap<>();
            response.put("message", message);
            response.put("timestamp", Instant.now().toString());
            response.put("executionTimeMs", Duration.between(start, Instant.now()).toMillis());

            // Ensure response is built efficiently to avoid memory issues in high-load scenarios
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            // Basic error handling to prevent startup or runtime failures propagating
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "An unexpected error occurred: " + e.getMessage());
            errorResponse.put("executionTimeMs", Duration.between(start, Instant.now()).toMillis());
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Simulates computational work to test for performance regressions across JVM versions.
     * Uses a simple loop to avoid external dependencies and focus on core Java performance.
     */
    private void performSimulatedWork() {
        // Light-weight simulation; can be adjusted for testing
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        // Discard sum to avoid compiler optimization removing the loop
        if (sum == 0) {
            throw new IllegalStateException("Simulation failed");
        }
    }

    /**
     * Health check endpoint to verify Spring Boot startup and runtime stability post-Java upgrade.
     * Returns a simple status to confirm no startup failures.
     * @return Basic health status map.
     */
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "TestController");
        return status;
    }
}