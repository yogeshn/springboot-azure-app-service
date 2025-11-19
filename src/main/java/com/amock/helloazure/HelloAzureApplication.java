package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Hello Azure Spring Boot application.
 * This class bootstraps the application context and starts the embedded server.
 *
 * Updated for Java 17+ compatibility, including support for records and sealed classes if extended.
 * No API shifts affecting this class; ensures smooth integration with refactored controller and tests.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Starts the Spring Boot application.
     * Handles command-line arguments and runs the application context.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
            // Log startup success or handle any startup exceptions
            System.out.println("HelloAzureApplication started successfully.");
        } catch (Exception e) {
            // Basic error handling for startup failures
            System.err.println("Failed to start HelloAzureApplication: " + e.getMessage());
            e.printStackTrace();
            // Exit with non-zero code on failure
            System.exit(1);
        }
    }
}