package com.amock.helloazure.controller;

import com.amock.helloazure.model.MyName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController for basic smoke testing of the HelloAzure application.
 * Provides simple endpoints to verify application startup and functionality.
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Simple GET endpoint to verify application is running.
     * Returns a basic hello message.
     *
     * @return ResponseEntity with HTTP 200 and "Hello from Azure!" message
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        logger.info("Hello endpoint accessed - verifying basic functionality");
        return ResponseEntity.ok("Hello from Azure!");
    }

    /**
     * GET endpoint to test model usage with optional parameters.
     * Creates and returns a MyName object. If parameters are provided, uses them; otherwise, defaults.
     *
     * @param firstName optional first name parameter
     * @param lastName optional last name parameter
     * @return ResponseEntity with HTTP 200 and MyName object, or HTTP 400 if invalid input
     */
    @GetMapping("/name")
    public ResponseEntity<MyName> getName(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        try {
            logger.info("Name endpoint accessed with params: firstName={}, lastName={}", firstName, lastName);
            
            // Edge case: handle null or empty strings by providing defaults
            String fn = (firstName != null && !firstName.trim().isEmpty()) ? firstName.trim() : "John";
            String ln = (lastName != null && !lastName.trim().isEmpty()) ? lastName.trim() : "Doe";
            
            MyName name = new MyName(fn, ln);
            return ResponseEntity.ok(name);
        } catch (Exception e) {
            logger.error("Error in getName endpoint: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}