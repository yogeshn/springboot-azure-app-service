package com.amock.helloazure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController handles HTTP requests for the Hello Azure application.
 * This controller provides endpoints to test basic functionality and ensure
 * no regressions in performance or behavior. It preserves original application
 * invariants such as startup sequence and endpoint responses.
 * 
 * No new Java features are used in this code, so no documentation updates are
 * required beyond standard JavaDoc.
 */
@RestController
public class TestController {

    /**
     * Handles GET requests to the /hello endpoint.
     * Returns a simple greeting message.
     * 
     * @return a ResponseEntity containing the greeting string
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        // Key logic: Return a fixed response to maintain invariant behavior
        return ResponseEntity.ok("Hello Azure");
    }

    /**
     * Handles GET requests to the /greet endpoint with an optional name parameter.
     * This endpoint allows for edge case testing with or without the name parameter.
     * 
     * @param name an optional request parameter for personalization
     * @return a ResponseEntity containing the personalized greeting or default message
     */
    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam(value = "name", required = false) String name) {
        try {
            if (name != null && !name.trim().isEmpty()) {
                // Key logic: Personalize the greeting if name is provided and valid
                return ResponseEntity.ok("Hello, " + name + "!");
            } else {
                // Edge case: Handle null or empty name by falling back to default
                return ResponseEntity.ok("Hello, World!");
            }
        } catch (Exception e) {
            // Error handling: Catch any unexpected exceptions and return a generic error response
            return ResponseEntity.internalServerError().body("An error occurred while processing the request.");
        }
    }
}