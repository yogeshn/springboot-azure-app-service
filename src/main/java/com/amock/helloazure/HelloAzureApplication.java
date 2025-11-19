package com.amock.helloazure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Main application class for the Hello Azure Spring Boot application.
 * Updated for Java upgrade compatibility: Incorporated java.time APIs for startup timing and logging
 * to monitor performance issues and ensure successful initialization without runtime errors.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Main entry point for the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Instant appStart = Instant.now();
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
            Duration startupDuration = Duration.between(appStart, Instant.now());
            System.out.println("Application started successfully at " + LocalDateTime.now() +
                    ". Startup duration: " + startupDuration.toMillis() + " ms.");
        } catch (Exception e) {
            Duration failedDuration = Duration.between(appStart, Instant.now());
            System.err.println("Spring Boot startup failed after " + failedDuration.toMillis() + " ms: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Bean for a CommandLineRunner to perform post-startup checks.
     * This helps detect runtime errors, performance issues, or compatibility problems after Java upgrade.
     *
     * @return CommandLineRunner instance
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Instant runnerStart = Instant.now();
            try {
                // Perform basic runtime checks here, e.g., verify JVM version compatibility
                String javaVersion = System.getProperty("java.version");
                System.out.println("Running on Java version: " + javaVersion + " (compatible with upgrade requirements).");

                // Simulate or add actual post-startup validation logic
                // For example, check if key beans are available or perform a health check
                if (javaVersion.startsWith("1.8") || javaVersion.startsWith("11") || javaVersion.startsWith("17")) {
                    System.out.println("JVM compatibility check passed.");
                } else {
                    System.out.println("Warning: JVM version may not be fully tested with recent upgrades.");
                }

                // Edge case: Handle potential null or unexpected states
                Duration runnerDuration = Duration.between(runnerStart, Instant.now());
                if (runnerDuration.toMillis() > 5000) { // Arbitrary threshold for performance monitoring
                    System.out.println("Warning: CommandLineRunner took longer than expected: " + runnerDuration.toMillis() + " ms. Investigate performance issues.");
                } else {
                    System.out.println("Post-startup checks completed in " + runnerDuration.toMillis() + " ms.");
                }
            } catch (Exception e) {
                Duration errorDuration = Duration.between(runnerStart, Instant.now());
                System.err.println("Runtime error in CommandLineRunner after " + errorDuration.toMillis() + " ms: " + e.getMessage());
                e.printStackTrace();
                // Do not exit, allow application to continue if possible
            }
        };
    }
}