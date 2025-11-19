package com.amock.helloazure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController provides a simple endpoint for verifying application startup and Java 17 compatibility.
 * This controller ensures robust handling of requests with minimal changes to preserve existing behavior.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Handles GET requests to /test endpoint.
     * Returns a simple success message to verify the application is running correctly on Java 17.
     * Includes basic error handling for unexpected issues, though none are anticipated in this minimal endpoint.
     *
     * @return ResponseEntity with success message and HTTP 200 status, or error response if issues occur.
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        try {
            // Log the request for debugging and monitoring
            logger.info("Received request to /test endpoint");

            // Simple response to confirm Java 17 runtime and application startup
            String responseMessage = "Hello from HelloAzure application running on Java 17!";

            // Validate response is not null (defensive programming, though statically known)
            if (responseMessage == null) {
                logger.error("Unexpected null response message generated");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error: Unable to generate response");
            }

            logger.debug("Successfully processed /test request");
            return ResponseEntity.ok(responseMessage);

        } catch (Exception e) {
            // Catch any unexpected exceptions to prevent server errors from propagating
            logger.error("Unexpected error in /test endpoint", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: An unexpected issue occurred during request processing");
        }
    }
}