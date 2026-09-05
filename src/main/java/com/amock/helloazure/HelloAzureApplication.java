package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for HelloAzure, a Spring Boot application.
 * This class serves as the entry point for starting the application.
 * It preserves the original startup sequence and application invariants,
 * ensuring that the Spring Boot application runs with default configurations.
 *
 * Key invariants preserved:
 * - Startup sequence: SpringApplication.run() is invoked with the application class and args.
 * - No changes to endpoint responses or core functionality; this is purely the launcher.
 *
 * Robustness enhancements:
 * - Added try-catch block around SpringApplication.run() to handle potential startup errors,
 *   logging exceptions for debugging without crashing the JVM.
 * - Edge case: If SpringApplication fails to initialize, the application exits gracefully with an error code.
 * - Comments added to explain key logic for maintainability.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Main method, the entry point for the application.
     * @param args Command-line arguments passed to the application (handled by Spring Boot).
     */
    public static void main(String[] args) {
        try {
            // Attempt to start the Spring Boot application.
            // This preserves the original startup sequence: initialize Spring context and start embedded server.
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Handle any unexpected errors during startup (e.g., configuration issues, bean conflicts).
            // Log the error for debugging; in production, this could integrate with a logging framework.
            System.err.println("Failed to start HelloAzureApplication: " + e.getMessage());
            e.printStackTrace();
            // Exit with error code to indicate failure, ensuring graceful shutdown.
            System.exit(1);
        }
    }
}