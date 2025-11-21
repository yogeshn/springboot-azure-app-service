package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * TestController handles basic test endpoints for the Hello Azure application.
 * This controller has been updated to use modern Spring Boot APIs (e.g., ResponseEntity for responses)
 * and Java syntax compatible with Java 17+. Deprecated APIs like old HttpEntity usage have been replaced.
 * Ensures compatibility across environments by avoiding platform-specific code.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * Simple GET endpoint to test the application context.
     * Returns a greeting message. Updated to use ResponseEntity for better HTTP handling.
     * 
     * @return ResponseEntity with greeting message
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from Azure!");
    }

    /**
     * GET endpoint with a query parameter for personalized greeting.
     * Handles optional name parameter with proper null/empty checks for edge cases.
     * 
     * @param name optional name parameter
     * @return ResponseEntity with personalized or default greeting
     */
    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam(value = "name", required = false) Optional<String> name) {
        try {
            String greeting = name
                    .filter(n -> !n.trim().isEmpty())
                    .map(n -> "Hello, " + n.trim() + " from Azure!")
                    .orElse("Hello from Azure! (No name provided)");
            return ResponseEntity.ok(greeting);
        } catch (Exception e) {
            // Basic error handling for unexpected issues, e.g., invalid params
            return ResponseEntity.internalServerError().body("Error generating greeting: " + e.getMessage());
        }
    }

    /**
     * Health check endpoint to validate application status across environments.
     * Returns OK if the endpoint is reachable, covering basic compatibility.
     * 
     * @return ResponseEntity indicating health status
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        // Simulate a simple check; in production, integrate with actual health indicators
        return ResponseEntity.ok("Application is healthy and compatible with current Java/Spring Boot version.");
    }
}