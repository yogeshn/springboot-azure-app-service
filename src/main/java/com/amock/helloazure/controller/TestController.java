package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestController handles basic REST endpoints for the Hello Azure application.
 * 
 * Java 17 Compliance Notes:
 * - Utilizes records or modern features if applicable in future extensions (none required here for basic structure).
 * - Ensures compatibility with Spring Boot 3.x (which supports Java 17+).
 * - No module-info.java adjustments needed as this is a non-modular project; if modularized, add 'requires spring.web;'.
 * 
 * Version Mappings:
 * - Java: 17 (minimum runtime version for seamless integration).
 * - Spring Boot: 3.0+ (aligned with Java 17 baseline).
 * - No changes to existing configurations; preserves project layout.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Simple GET endpoint to test the controller.
     * 
     * @return A greeting message.
     */
    @GetMapping
    public ResponseEntity<String> testEndpoint(@RequestParam(defaultValue = "World") String name) {
        try {
            // Log incoming request for traceability
            logger.info("Received test request with name: {}", name);
            
            String message = String.format("Hello, %s! This is TestController running on Java 17.", name);
            
            // Edge case: Handle empty name
            if (name == null || name.trim().isEmpty()) {
                message = "Hello! No name provided.";
            }
            
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            logger.error("Error in testEndpoint: {}", e.getMessage());
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Health check endpoint for runtime validation.
     * 
     * @return Status message confirming environment setup.
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        // Basic runtime validation
        String javaVersion = System.getProperty("java.version");
        logger.info("Health check - Java Version: {}", javaVersion);
        
        if (javaVersion.startsWith("17")) {
            return ResponseEntity.ok("Application healthy - Running on Java 17");
        } else {
            logger.warn("Java version mismatch: {}", javaVersion);
            return ResponseEntity.ok("Application running, but Java version is " + javaVersion + " (expected 17)");
        }
    }
}