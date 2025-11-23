package com.amock.helloazure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController handles simple test endpoints for the Hello Azure application.
 * This controller provides basic REST API endpoints to test application functionality.
 * It follows Spring Boot best practices and ensures no deprecated APIs are used.
 * Key logic: Endpoints return simple string responses for testing purposes.
 * Error handling: Basic Spring exception handling is relied upon; no custom exceptions here.
 * Edge cases: Minimal input/output, so edge cases are not applicable.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * Endpoint to return a simple hello message.
     * This method serves as a basic health check or demonstration endpoint.
     * 
     * @return A string message "Hello Azure"
     */
    @GetMapping("/hello")
    public String hello() {
        // No business logic beyond returning a static message; preserved as is.
        return "Hello Azure";
    }

    // Additional endpoints can be added here if needed, but keeping it simple per requirements.
}