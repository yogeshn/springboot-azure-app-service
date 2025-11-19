package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Hello Azure Spring Boot application.
 * This class has been reviewed and refactored for Java 11+ compatibility,
 * ensuring no deprecated APIs are used. It initializes the Spring application
 * context efficiently with minimal overhead. No structural changes were needed,
 * but added comments for clarity and maintained consistency with other refactored files.
 * 
 * Key considerations:
 * - Uses Spring Boot 2.7+ (compatible with Java 11+).
 * - No custom configurations or beans added to avoid unnecessary complexity.
 * - Error handling is delegated to Spring Boot's default mechanisms for robustness.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Starts the Spring Boot application.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        // Efficiently run the application with standard Spring Boot runner.
        // This loads the context and starts embedded server if applicable.
        // Edge case: Handles args gracefully; Spring Boot manages exceptions like invalid profiles.
        SpringApplication.run(HelloAzureApplication.class, args);
    }
}