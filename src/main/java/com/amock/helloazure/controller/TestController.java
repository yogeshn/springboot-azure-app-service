package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * TestController provides a simple REST endpoint for testing the application.
 * This controller handles GET requests and returns a basic response.
 * 
 * Key improvements:
 * - Added proper logging for request tracking and debugging.
 * - Ensured response is consistent and backward compatible.
 * - Included basic error handling for unexpected issues.
 * - Improved code readability with comments and structured imports.
 * - Addressed potential security concerns by avoiding direct input processing (no parameters in this endpoint).
 * - Performance: Lightweight endpoint with minimal computation.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Handles GET requests to /api/test.
     * Returns a simple "Hello Azure" message with timestamp for verification.
     * 
     * @return ResponseEntity containing the success message.
     */
    @GetMapping
    public ResponseEntity<String> getTestMessage() {
        try {
            // Log the incoming request for audit and debugging purposes
            logger.info("Test endpoint accessed at {}", LocalDateTime.now());
            
            String message = "Hello from Azure! Timestamp: " + LocalDateTime.now();
            
            // Validate message length as a simple edge case check (e.g., prevent empty responses)
            if (message.isEmpty()) {
                logger.warn("Unexpected empty message generated");
                return ResponseEntity.badRequest().body("Error: Invalid response generated");
            }
            
            logger.debug("Successfully generated test message: {}", message);
            return ResponseEntity.ok(message);
            
        } catch (Exception e) {
            // Handle any runtime exceptions gracefully
            logger.error("Error in test endpoint: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Internal server error occurred");
        }
    }
}