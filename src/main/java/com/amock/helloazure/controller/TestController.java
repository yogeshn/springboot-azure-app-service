package com.amock.helloazure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TestController handles basic test endpoints for the Hello Azure application.
 * This controller has been refactored for better maintainability, input validation,
 * error handling, and performance considerations. It ensures separation of concerns
 * by focusing solely on HTTP request/response handling, delegating business logic
 * where possible.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    // Constants to replace magic numbers for better readability and maintainability
    private static final int DEFAULT_MULTIPLIER = 2;
    private static final int MIN_LIST_SIZE = 1;
    private static final String PROCESSING_ERROR_MSG = "Error during data processing";

    /**
     * Simple GET endpoint to return a hello message.
     * No significant changes needed; added for completeness and test coverage.
     *
     * @return Greeting message
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from TestController!");
    }

    /**
     * POST endpoint to process a list of strings by duplicating each (e.g., for length * 2).
     * Refactored to:
     * - Validate input (null/empty checks)
     * - Use constants instead of magic numbers
     * - Stream API for O(n) processing with better performance
     * - Proper error handling with try-catch for graceful failures
     * - Group related data (list) in request body; future: could use a DTO for data clumps
     *
     * Edge cases covered: null list, empty list, invalid sizes.
     *
     * @param inputList List of strings to process
     * @return Processed list or error response
     */
    @PostMapping("/process")
    public ResponseEntity<?> processList(@RequestBody List<String> inputList) {
        try {
            // Input validation for edge cases
            if (inputList == null) {
                return ResponseEntity.badRequest()
                        .body("Input list cannot be null");
            }
            if (inputList.size() < MIN_LIST_SIZE) {
                return ResponseEntity.badRequest()
                        .body("Input list must have at least " + MIN_LIST_SIZE + " elements");
            }

            // Process using Stream API for efficient O(n) operation; avoids explicit loops for clarity
            // Potential optimization: For very large lists, consider parallel streams based on usage patterns
            List<String> processed = inputList.stream()
                    .map(str -> {
                        // Simulate processing: duplicate string (e.g., length * DEFAULT_MULTIPLIER logic could be here)
                        if (str == null || str.isEmpty()) {
                            throw new IllegalArgumentException("Invalid string element: null or empty");
                        }
                        return str + str; // Example: duplicate for simplicity; replace with actual logic
                    })
                    .collect(Collectors.toList());

            // Resource management: Streams auto-close, no explicit cleanup needed
            return ResponseEntity.ok(processed);

        } catch (IllegalArgumentException e) {
            // Specific handling for validation errors
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // General error handling for unexpected conditions (e.g., out-of-memory for large inputs)
            // Log the error in production (e.g., via SLF4J); here, return graceful response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(PROCESSING_ERROR_MSG + ": " + e.getMessage());
        }
    }

    /**
     * GET endpoint for a simple computation to demonstrate refactoring.
     * Originally might have had magic numbers or poor complexity; now uses constants
     * and clear logic. O(1) operation.
     *
     * @param input A numeric input (query param)
     * @return Computed result
     */
    @GetMapping("/compute")
    public ResponseEntity<String> compute(@RequestParam(defaultValue = "1") int input) {
        try {
            // Input validation
            if (input <= 0) {
                return ResponseEntity.badRequest().body("Input must be positive");
            }

            // Example computation: input * DEFAULT_MULTIPLIER; avoids magic numbers
            int result = input * DEFAULT_MULTIPLIER;

            // Comments for key logic: This is O(1); for larger computations, profile performance
            return ResponseEntity.ok("Computed result: " + result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Computation failed: " + e.getMessage());
        }
    }
}