package com.amock.helloazure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TestController provides a simple REST endpoint for testing application functionality.
// This class is part of the main application code and remains unchanged as the task focuses on test configurations.
// No modifications are required here to support Java version upgrades, as it's not a test file or configuration.

@RestController
public class TestController {

    @GetMapping("/test")
    public String testEndpoint() {
        // Returns a simple string response for testing purposes.
        // Edge case: If the endpoint is called without proper authentication, it would return this message,
        // but actual security should be handled at a higher level (e.g., via Spring Security).
        try {
            // Simulate some processing, though minimal for this example.
            String message = "Test endpoint response";
            // No complex logic, so no need for extensive error handling beyond basic try-catch if expanded.
            return message;
        } catch (Exception e) {
            // Basic error handling: log the exception and return a fallback message.
            System.err.println("Error in testEndpoint: " + e.getMessage());
            return "Error occurred";
        }
    }
}