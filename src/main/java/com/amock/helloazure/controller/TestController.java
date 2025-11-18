package com.amock.helloazure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * Controller for test endpoints in the Hello Azure application.
 */
@RestController
public class TestController {

    /**
     * Simple greeting endpoint that returns a welcome message.
     * 
     * @return A greeting message
     */
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello, Azure!");
    }

    /**
     * Echo endpoint that returns the provided message.
     * 
     * @param message The message to echo
     * @return The echoed message or a default message if none provided
     */
    @GetMapping("/echo")
    public ResponseEntity<String> echo(@RequestParam(required = false) String message) {
        if (message == null || message.trim().isEmpty()) {
            return ResponseEntity.ok("You didn't say anything!");
        }
        return ResponseEntity.ok("Echo: " + message);
    }

    /**
     * Status endpoint to check the service health.
     * 
     * @return Status information about the service
     */
    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Service is running");
    }

    /**
     * Error simulation endpoint to test error handling.
     * 
     * @param type The type of error to simulate
     * @return An error response based on the requested type
     */
    @GetMapping("/simulateError")
    public ResponseEntity<String> simulateError(@RequestParam(required = false, defaultValue = "none") String type) {
        switch (type.toLowerCase()) {
            case "client":
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Simulated client error");
            case "server":
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Simulated server error");
            case "unauthorized":
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Simulated unauthorized error");
            default:
                return ResponseEntity.ok("No error simulated");
        }
    }
}