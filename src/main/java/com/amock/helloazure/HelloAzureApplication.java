package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * HelloAzureApplication is the main entry point for the Spring Boot application.
 * It bootstraps the application using SpringApplication.run().
 * This class has been updated to ensure compatibility with Java 11+ and Spring Boot 3,
 * removing any deprecated APIs and maintaining robust error handling for startup failures.
 */
@SpringBootApplication
public class HelloAzureApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Log the exception for debugging and handle startup failures gracefully
            System.err.println("Failed to start Spring Boot application: " + e.getMessage());
            e.printStackTrace();
            // Exit with error code to indicate failure
            System.exit(1);
        }
    }

}