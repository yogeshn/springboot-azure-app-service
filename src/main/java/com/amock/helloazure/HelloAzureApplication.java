package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloAzureApplication {

    public static void main(String[] args) {
        // Attempt to run the Spring Boot application
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Log the error for debugging purposes
            System.err.println("Failed to start the application: " + e.getMessage());
            e.printStackTrace();
            // Exit with a non-zero status to indicate failure
            System.exit(1);
        }
    }
}