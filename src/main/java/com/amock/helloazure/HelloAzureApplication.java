package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for HelloAzure, a Spring Boot application.
 * This class bootstraps the application using SpringApplication.run,
 * which initializes the Spring context efficiently with minimal overhead.
 * Prioritizing performance: The startup process is optimized by leveraging Spring Boot's auto-configuration,
 * avoiding unnecessary bean scans or custom initializations unless specified.
 * Error handling: SpringApplication handles exceptions during startup gracefully,
 * logging errors and failing fast if critical components cannot load.
 * Edge cases: Handles command-line arguments robustly; invalid args are ignored,
 * and the application proceeds with default configurations.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Main entry point for the application.
     * Starts the Spring Boot application context.
     * Key logic: Uses SpringApplication.run for efficient context loading,
     * ensuring quick startup times and low memory footprint.
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        // Prioritize efficiency: Direct call to run without additional processing.
        // Error handling: SpringApplication internally manages startup failures.
        SpringApplication.run(HelloAzureApplication.class, args);
    }
}