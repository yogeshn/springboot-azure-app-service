package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the HelloAzure Spring Boot application.
 * This class bootstraps the application, loading the Spring context and starting the embedded server.
 * It uses the @SpringBootApplication annotation, which enables auto-configuration, component scanning,
 * and acts as a configuration class.
 * 
 * Key responsibilities:
 * - Initialize and run the Spring Boot application.
 * - Handle basic startup configuration.
 * 
 * Error handling: The SpringApplication.run() method includes built-in error handling for context loading failures,
 * logging errors and providing exit codes. For production robustness, consider adding custom error handlers or
 * configuration for graceful shutdown.
 * 
 * Edge cases: Handles empty args gracefully; supports Spring profiles via command-line arguments (e.g., --spring.profiles.active=dev).
 * Ensures the application starts even if optional configurations are missing, falling back to defaults.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Main method to start the Spring Boot application.
     * 
     * @param args Command-line arguments, which can include Spring Boot configuration properties.
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Additional logging for unhandled startup exceptions to aid debugging.
            // This preserves the default Spring Boot error handling while adding visibility.
            System.err.println("Failed to start HelloAzureApplication: " + e.getMessage());
            e.printStackTrace();
            System.exit(1); // Exit with error code to indicate startup failure.
        }
    }
}