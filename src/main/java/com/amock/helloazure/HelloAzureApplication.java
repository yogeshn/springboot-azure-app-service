package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main entry point for the HelloAzure Spring Boot application.
 * This class serves as the primary application class, enabling auto-configuration
 * and component scanning. It extends SpringBootServletInitializer to support
 * deployment as a traditional WAR file in servlet containers like Tomcat.
 * 
 * Key features:
 * - Auto-configuration via @SpringBootApplication
 * - Support for both executable JAR (via main method) and WAR deployment (via configure method)
 * - Preserves all existing logic for Spring Boot integration
 * 
 * No breaking changes identified; code is compatible with Java 8+ and recent Spring Boot versions.
 * Error handling is managed at the framework level; no custom exceptions thrown here.
 */
@SpringBootApplication
public class HelloAzureApplication extends SpringBootServletInitializer {

    /**
     * Configures the SpringApplicationBuilder for WAR deployment.
     * This method is invoked by the servlet container during WAR initialization.
     * Ensures the application context is built with the correct sources.
     * 
     * @param application the SpringApplicationBuilder to configure
     * @return the configured SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Edge case: Null check not needed as builder is provided by framework
        return application.sources(HelloAzureApplication.class);
    }

    /**
     * Main method to run the application as an executable JAR.
     * Delegates to SpringApplication.run for context initialization.
     * Handles args for profiles, properties, etc., as per Spring Boot conventions.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Prioritize efficiency: Direct run without unnecessary wrappers
        // Error handling: Spring Boot handles startup failures with detailed logs
        SpringApplication.run(HelloAzureApplication.class, args);
    }
}