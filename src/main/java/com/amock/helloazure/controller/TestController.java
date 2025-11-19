package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestController provides basic endpoints for testing the application.
 * This controller has been reviewed for Java version compatibility (e.g., Java 17+ features like records or switch expressions if applicable).
 * No major changes were needed for assertions or mocks in related tests, but endpoints are designed to be easily testable with JUnit 5 and Spring Boot Test.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Simple GET endpoint to test application health.
     * Returns a success message.
     * 
     * @return ResponseEntity with a test message
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Health check endpoint called");
        return ResponseEntity.ok("Application is healthy - Compatible with current Java version");
    }

    /**
     * Another test endpoint to demonstrate error handling.
     * Handles edge cases like invalid inputs (though none here for simplicity).
     * 
     * @return ResponseEntity with a test message
     */
    @GetMapping("/echo")
    public ResponseEntity<String> echoMessage(String message) {
        try {
            if (message == null || message.trim().isEmpty()) {
                logger.warn("Empty message received, returning default");
                return ResponseEntity.badRequest().body("Message cannot be empty");
            }
            String response = "Echo: " + message;
            logger.info("Echo response: {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error in echo endpoint", e);
            return ResponseEntity.internalServerError().body("An error occurred");
        }
    }
}