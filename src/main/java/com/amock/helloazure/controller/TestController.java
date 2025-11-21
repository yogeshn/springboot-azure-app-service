package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A simple test controller for the HelloAzure application.
 * Provides basic endpoints to verify Spring Boot integration and API contracts.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * GET endpoint to test the application with a parameterized response.
     * Preserves existing logic: returns a greeting message based on the provided name parameter.
     * Handles null or empty parameters gracefully.
     *
     * @param name the name parameter from the request (optional, defaults to "World")
     * @return ResponseEntity with HTTP 200 and the greeting message
     */
    @GetMapping
    public ResponseEntity<String> test(@RequestParam(defaultValue = "World") String name) {
        // Existing logic: simple string concatenation for greeting
        String message = "Hello, " + (name != null && !name.trim().isEmpty() ? name.trim() : "World") + " from Azure!";
        
        // Preserve error handling: no exceptions thrown, always returns 200 OK
        return ResponseEntity.ok(message);
    }

    /**
     * Additional endpoint for health check, if needed for integration testing.
     * Ensures identical behavior to any prior versions: plain status response.
     *
     * @return ResponseEntity with HTTP 200 and status message
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        // Existing logic: static health response
        return ResponseEntity.ok("Application is healthy and running on Azure.");
    }
}