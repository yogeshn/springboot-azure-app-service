package com.amock.helloazure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController handles basic test endpoints for the HelloAzure application.
 * This controller provides a simple health check and parameterized greeting.
 * Ensures alignment with Spring Boot 3.x and Java 17+ features for optimal performance.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Simple health check endpoint.
     * Returns a static message to verify controller functionality.
     * Optimized for low latency with no heavy computations.
     *
     * @return Fixed greeting message
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        logger.debug("Test endpoint accessed");
        String message = "Hello Azure! Application is running.";
        return ResponseEntity.ok(message);
    }

    /**
     * Parameterized greeting endpoint.
     * Accepts a name parameter for personalized response.
     * Includes input validation to prevent edge cases like null or empty inputs.
     * Handles potential exceptions gracefully for robustness.
     *
     * @param name Optional name parameter (default: "World")
     * @return Personalized greeting
     */
    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam(defaultValue = "World") String name) {
        logger.info("Greet endpoint accessed with name: {}", name);
        
        // Edge case handling: trim and validate input to avoid empty strings or excessive length
        if (name == null || name.trim().isEmpty() || name.length() > 100) {
            name = "World"; // Fallback to default
            logger.warn("Invalid name parameter provided; using default");
        } else {
            name = name.trim();
        }
        
        // Efficient string concatenation using String.format for readability and performance
        String message = String.format("Hello, %s! Welcome to Azure.", name);
        return ResponseEntity.ok(message);
    }

    /**
     * Global exception handler for this controller.
     * Catches any unexpected runtime exceptions and returns a 500 error with logging.
     * Ensures no sensitive information is leaked in responses.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Unexpected error in TestController: {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred. Please try again later.");
    }

    /**
     * Additional endpoint for performance testing.
     * Demonstrates efficient handling without database or I/O calls.
     * Returns current timestamp for runtime validation.
     *
     * @return Timestamp string
     */
    @GetMapping("/time")
    public ResponseEntity<String> getTime() {
        logger.debug("Time endpoint accessed");
        long timestamp = System.currentTimeMillis();
        return ResponseEntity.ok(String.valueOf(timestamp));
    }
}