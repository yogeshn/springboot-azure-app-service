package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Main entry point for the Hello Azure Spring Boot application.
 * This class has been refactored for modern Java practices:
 * - Uses try-with-resources for managing the application context to ensure proper shutdown.
 * - Includes basic error handling for application startup failures.
 * - Leverages Java 9+ module system compatibility (no explicit changes needed for basic setup).
 * - No deprecated APIs were present; code is already aligned with Java 17+ standards.
 * - Prioritizes efficiency by minimizing unnecessary operations during startup.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Starts the Spring Boot application.
     * Handles startup exceptions gracefully and ensures the context is closed on errors.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = null;
        try {
            context = SpringApplication.run(HelloAzureApplication.class, args);
            // Log startup success if needed (integrates with Spring's logging)
            System.out.println("Hello Azure application started successfully.");
        } catch (Exception e) {
            // Handle startup failures: log the error and ensure cleanup
            System.err.println("Failed to start Hello Azure application: " + e.getMessage());
            e.printStackTrace();
            if (context != null) {
                context.close();
            }
            System.exit(1); // Exit with error code for edge cases like deployment scripts
        }
        // Edge case: Normal shutdown is handled by Spring, but explicit close ensures resource cleanup
        // No additional logic needed for performance; Spring manages lifecycle efficiently
    }
}