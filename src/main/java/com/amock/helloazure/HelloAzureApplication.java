package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the HelloAzure Spring Boot application.
 * This class bootstraps the application context and starts the embedded server.
 * It uses the @SpringBootApplication annotation to enable auto-configuration,
 * component scanning, and other Spring Boot features.
 * 
 * No deprecated APIs are used here. This class is compatible with Java 11+ and
 * Spring Boot 3.x, which uses Jakarta EE where applicable (though not directly
 * in this file). Business logic is preserved as the core startup mechanism.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * The main method that runs the Spring Boot application.
     * It delegates to SpringApplication.run() to initialize the application context
     * with the provided command-line arguments.
     * 
     * Error handling: Spring Boot handles startup exceptions internally,
     * logging errors and exiting with appropriate status codes.
     * Edge cases: Handles empty args gracefully; supports profile activation
     * via command-line flags (e.g., --spring.profiles.active=test).
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloAzureApplication.class, args);
    }
}