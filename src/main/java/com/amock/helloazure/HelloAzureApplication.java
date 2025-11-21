package com.amock.helloazure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Main entry point for the Hello Azure Spring Boot application.
 * This class initializes the Spring context and performs basic startup validation.
 * Ensures backward compatibility by maintaining standard Spring Boot lifecycle.
 * Added logging for runtime compatibility confirmation and error handling for edge cases.
 */
@SpringBootApplication
public class HelloAzureApplication {

    private static final Logger logger = LoggerFactory.getLogger(HelloAzureApplication.class);

    public static void main(String[] args) {
        // Edge case: Handle null or empty arguments
        if (args == null || args.length == 0) {
            logger.info("No command-line arguments provided. Starting application with default configuration.");
        } else {
            logger.info("Starting application with arguments: {}", String.join(", ", args));
        }

        ConfigurableApplicationContext context = null;
        try {
            // Run the Spring Boot application
            context = SpringApplication.run(HelloAzureApplication.class, args);
            
            // Manual verification of environments (basic check)
            Environment env = context.getEnvironment();
            String activeProfiles = String.join(", ", env.getActiveProfiles());
            logger.info("Application started successfully. Active profiles: {}", activeProfiles.isEmpty() ? "default" : activeProfiles);
            logger.info("Hello Azure! Application is ready for deployment.");
            
            // Confirm runtime compatibility by logging key properties
            logger.info("Java Version: {}", System.getProperty("java.version"));
            logger.info("Build Timestamp: {}", System.getProperty("build.timestamp", "Not available"));
            
        } catch (Exception e) {
            // Proper error handling for startup failures
            logger.error("Failed to start Hello Azure application", e);
            System.exit(1);
        }

        // Keep the application running; shutdown handled by Spring context
        if (context != null) {
            try {
                context.registerShutdownHook();
                logger.debug("Shutdown hook registered for graceful exit.");
            } catch (Exception e) {
                logger.warn("Failed to register shutdown hook", e);
            }
        }
    }
}