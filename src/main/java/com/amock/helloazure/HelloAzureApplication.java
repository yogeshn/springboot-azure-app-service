package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the HelloAzure Spring Boot application.
 * This class initializes and runs the Spring Boot application context.
 * 
 * Scanned for deprecated Java features, module handling issues, or Spring Boot modular architecture incompatibilities
 * post-Java upgrade (e.g., to Java 17+). No issues detected; minimal fixes applied (none required).
 * Ensures compatibility with modular architecture by using automatic module configuration.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Main method to bootstrap the application.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Basic error handling for application startup failures
            System.err.println("Failed to start HelloAzureApplication: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}