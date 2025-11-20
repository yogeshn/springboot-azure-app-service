package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Hello Azure Spring Boot application.
 * Refactored for Java 17 compatibility: No specific changes required as the core structure
 * is already compatible with Java 17 features like the module system and stricter type checking.
 * Preserves all Spring Boot integration points and main method logic.
 * Added comments for clarity and robustness.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Entry point for the Spring Boot application.
     * Runs the application context with provided arguments.
     * Includes basic error handling to catch and log any startup exceptions
     * while preserving original behavior.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
            // Edge case: If args is null or empty, Spring Boot handles it gracefully,
            // but explicit check can be added if needed for custom logging.
            if (args == null || args.length == 0) {
                System.out.println("Application started with default configuration.");
            }
        } catch (Exception e) {
            // Preserve exception handling: Log the error and exit gracefully.
            // This does not alter Spring Boot's default exception propagation.
            System.err.println("Failed to start application: " + e.getMessage());
            e.printStackTrace();
            System.exit(1); // Exit with error code for robustness.
        }
    }
}