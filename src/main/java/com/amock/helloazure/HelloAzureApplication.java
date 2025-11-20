package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Hello Azure Spring Boot application.
 * This class serves as the entry point for the application, bootstrapping
 * the Spring context and starting the embedded server.
 * 
 * Compatible with Java 11: No deprecated APIs, sun.* packages, or legacy
 * date/time APIs are used. All imports and code patterns adhere to Java 11
 * standards.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Application entry point.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Log the error for robustness; in a production environment, use a proper logger like SLF4J.
            System.err.println("Failed to start HelloAzureApplication: " + e.getMessage());
            e.printStackTrace();
            // Exit with non-zero code to indicate failure.
            System.exit(1);
        }
    }
}