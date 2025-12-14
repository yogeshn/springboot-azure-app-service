package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloAzureApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Handle any startup exceptions
            System.err.println("Application failed to start: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
