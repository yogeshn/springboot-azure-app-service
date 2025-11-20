package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController handles basic test endpoints for the application.
 * This controller is compatible with Java 11, using modern APIs and avoiding deprecated features.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * Simple GET endpoint to test the application.
     * Returns a success message.
     *
     * @return ResponseEntity with a hello message
     */
    @GetMapping
    public ResponseEntity<String> testEndpoint() {
        // Business logic: Simple string return, no deprecated APIs used
        String message = "Hello from TestController - Java 11 Compatible!";
        
        // Edge case: Empty response handling (though not applicable here)
        if (message == null || message.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(message);
    }

    /**
     * Another test method if needed, but preserving structure - no changes required for Java 11.
     * This demonstrates proper error handling with try-catch for potential exceptions.
     *
     * @return ResponseEntity with processed data
     */
    @GetMapping("/process")
    public ResponseEntity<String> processTest() {
        try {
            // Simulate data processing - no old date/time APIs (e.g., no java.util.Date)
            // Using java.time if needed, but here it's simple
            String processed = "Processed data: " + System.currentTimeMillis();
            
            // Edge case: Handle null or invalid input (though no params here)
            if (processed.length() > 1000) { // Arbitrary check
                throw new IllegalArgumentException("Data too long");
            }
            
            return ResponseEntity.ok(processed);
        } catch (Exception e) {
            // Proper error handling
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}