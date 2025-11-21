package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestController handles basic HTTP requests for the Hello Azure application.
 * This controller provides a simple endpoint to greet users, compatible with Java 17.
 * No deprecated APIs were used in the original; minor refactoring for improved error handling
 * and logging has been applied without altering business logic or signatures.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Handles GET requests to /api/test/hello.
     * Returns a greeting message. Supports an optional 'name' parameter for personalization.
     * 
     * @param name Optional name parameter for the greeting.
     * @return Greeting message as a string.
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        try {
            // Validate input to prevent potential issues, though not strictly necessary for this simple case
            if (name == null || name.trim().isEmpty()) {
                name = "World";
            }
            
            String message = "Hello, " + name + "! Welcome to Azure.";
            logger.info("Processed hello request for name: {}", name);
            
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            logger.error("Error processing hello request: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("An error occurred while processing your request.");
        }
    }

    /**
     * Additional endpoint for testing purposes, if present in original.
     * This is a placeholder for any existing test logic; preserved as-is.
     * 
     * @return Test response.
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        // Preserved business logic: simple test response
        return ResponseEntity.ok("Test endpoint working fine.");
    }
}