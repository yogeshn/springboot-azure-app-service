package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the HelloAzure Spring Boot application.
 * This class initializes and runs the Spring Boot application context.
 * It extends SpringBootServletInitializer to support deployment in a traditional servlet container.
 * 
 * Key considerations:
 * - Robustness: Wrapped the application run in a try-catch block to handle startup failures gracefully,
 *   logging errors and ensuring clean shutdown.
 * - Error Handling: Catches and logs any RuntimeExceptions during startup, preventing silent failures.
 * - Edge Cases: Handles cases where the application fails to start due to configuration issues,
 *   missing dependencies, or environmental problems (e.g., Azure-specific configs).
 * - Best Practices: Uses SLF4J for logging, enables auto-configuration, and supports both embedded
 *   and external servlet container deployment.
 * - Security: No direct security implications here; relies on Spring Boot's default security auto-config.
 * - Deprecated Features: Uses modern Spring Boot annotations; avoids deprecated APIs.
 * - Spring Boot Compatibility: Assumes Spring Boot 2.x+; validate version in pom.xml for mismatches.
 */
@SpringBootApplication
public class HelloAzureApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(HelloAzureApplication.class);

    /**
     * Configures the application for deployment in an external servlet container.
     * This method is called during WAR packaging to build the application context.
     *
     * @param applicationBuilder The SpringApplicationBuilder to configure.
     * @return The configured application builder.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(HelloAzureApplication.class);
    }

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            // Run the application with the main class as the source
            SpringApplication.run(HelloAzureApplication.class, args);
            logger.info("HelloAzureApplication started successfully.");
        } catch (Exception e) {
            // Catch any exceptions during startup for robust error handling
            logger.error("Failed to start HelloAzureApplication", e);
            // Optionally, perform cleanup or notify external systems (e.g., Azure monitoring)
            System.exit(1); // Exit with error code to indicate failure
        }
    }
}