package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the HelloAzure Spring Boot application.
 * This class bootstraps the application context and starts the embedded server.
 * Compatible with Java 17; no deprecated APIs used.
 * Handles standard Spring Boot initialization with error logging for robustness.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Starts the Spring Boot application.
     * Runs the application context with the provided arguments.
     * Includes basic error handling to log startup failures without altering core logic.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Log startup errors for robustness; do not alter application flow
            System.err.println("Failed to start HelloAzureApplication: " + e.getMessage());
            e.printStackTrace();
            System.exit(1); // Exit with error code on failure
        }
    }
}