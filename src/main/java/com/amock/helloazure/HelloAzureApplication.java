package com.amock.helloazure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloAzureApplication {

    private static final Logger logger = LoggerFactory.getLogger(HelloAzureApplication.class);

    public static void main(String[] args) {
        // Initialize Spring Boot application with error handling for robustness
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
            logger.info("HelloAzureApplication started successfully.");
        } catch (Exception e) {
            // Log the error and handle startup failure gracefully
            logger.error("Failed to start HelloAzureApplication: {}", e.getMessage(), e);
            System.err.println("Application startup failed due to: " + e.getMessage());
            // Exit with non-zero code to indicate failure, covering edge cases like configuration errors
            System.exit(1);
        }
    }

    // Additional method for potential future extensions, e.g., custom startup hooks
    // This ensures maintainability without altering core structure
    protected static void handleStartupEdgeCases(String[] args) {
        // Placeholder for edge case handling, e.g., validate args or environment
        if (args == null || args.length == 0) {
            logger.warn("No command-line arguments provided; using default configuration.");
        }
        // Extend as needed for specific Java version compatibility or refactoring
    }
}