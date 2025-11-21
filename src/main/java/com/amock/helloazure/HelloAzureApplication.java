package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Hello Azure Spring Boot application.
 * This class bootstraps the application context and starts the embedded server.
 * Supports configuration via application profiles for different environments (e.g., test, prod, azure).
 * 
 * Key logic:
 * - Uses @SpringBootApplication to enable auto-configuration, component scanning, and more.
 * - The main method runs the application with provided arguments, handling startup efficiently.
 * - Error handling is managed by Spring Boot's default mechanisms, with logging for diagnostics.
 * - Ensures compatibility with newer Java versions (e.g., 17+) by avoiding deprecated APIs.
 * 
 * Performance considerations:
 * - Minimal static initialization to reduce startup time.
 * - Lazy loading of beans where possible via Spring Boot defaults.
 * 
 * Edge cases:
 * - Handles missing arguments gracefully (defaults to empty).
 * - Supports profile activation via command-line args (e.g., --spring.profiles.active=azure).
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Starts the Spring Boot application.
     * 
     * @param args Command-line arguments, including profile specifications.
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Basic error handling: log and exit to prevent hanging processes
            System.err.println("Failed to start application: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}