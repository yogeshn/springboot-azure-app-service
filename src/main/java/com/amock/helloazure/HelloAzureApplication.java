package com.amock.helloazure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the HelloAzure Spring Boot application.
 * This class initializes and runs the Spring application context.
 * It preserves the original structure while adding basic error handling
 * for startup failures to ensure robustness in production environments.
 * Compatible with Java 17, with no deprecated APIs used.
 */
@SpringBootApplication
public class HelloAzureApplication {

    private static final Logger logger = LoggerFactory.getLogger(HelloAzureApplication.class);

    /**
     * Starts the Spring Boot application.
     * Handles potential startup exceptions gracefully, logging errors
     * without altering the core functionality or method signature.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
            logger.info("HelloAzureApplication started successfully.");
        } catch (Exception e) {
            logger.error("Failed to start HelloAzureApplication", e);
            // Exit with non-zero code to indicate failure, covering the edge case of startup errors
            System.exit(1);
        }
    }
}