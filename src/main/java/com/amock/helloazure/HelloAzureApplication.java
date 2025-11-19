package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the HelloAzure Spring Boot application.
 * Configures and starts the application context.
 * This class ensures the application starts successfully with the new Java version
 * and provides basic error handling for startup failures.
 */
@SpringBootApplication
public class HelloAzureApplication {

    private static final Logger logger = LoggerFactory.getLogger(HelloAzureApplication.class);

    public static void main(String[] args) {
        try {
            // Run the Spring Boot application
            SpringApplication.run(HelloAzureApplication.class, args);
            logger.info("HelloAzureApplication started successfully.");
        } catch (Exception e) {
            logger.error("Failed to start HelloAzureApplication", e);
            // Exit with error code to indicate failure, allowing for smoke test validation
            System.exit(1);
        }
    }
}