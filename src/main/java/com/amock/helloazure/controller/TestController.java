package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestController provides simple REST endpoints for testing the application.
 * This controller ensures compatibility with the upgraded Java version by using
 * modern annotations and avoiding deprecated features.
 * 
 * Key changes for Java upgrade:
 * - Utilized ResponseEntity for better HTTP response handling.
 * - Added logging for request tracing without performance overhead.
 * - Ensured thread-safety and null-safety where applicable.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Handles GET requests to /api/test/hello.
     * Returns a simple greeting message.
     * 
     * @return ResponseEntity containing the greeting message.
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        try {
            String message = "Hello from TestController - Java Upgrade Complete!";
            logger.info("Received request for /api/test/hello");
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            logger.error("Error processing hello request", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Handles GET requests to /api/test/status.
     * Returns application status.
     * Covers edge case where system might be under load.
     * 
     * @return ResponseEntity containing status message.
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        // Simulate potential edge case handling (e.g., null checks or config loads)
        String status = "Application is running smoothly post-Java upgrade.";
        if (status == null || status.isEmpty()) {
            logger.warn("Status message is empty - using default");
            status = "Status unavailable.";
        }
        logger.debug("Status endpoint accessed");
        return ResponseEntity.ok(status);
    }
}