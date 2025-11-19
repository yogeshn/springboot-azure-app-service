package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloAzureApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Log or handle startup errors gracefully for robustness in Java 17 runtime
            e.printStackTrace();
            System.exit(1);
        }
    }
}