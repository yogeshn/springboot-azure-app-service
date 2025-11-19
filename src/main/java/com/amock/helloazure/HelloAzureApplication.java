package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Hello Azure Spring Boot application.
 * 
 * This class serves as the entry point for the application and is responsible for bootstrapping
 * the Spring context. It uses the @SpringBootApplication annotation, which combines
 * @Configuration, @EnableAutoConfiguration, and @ComponentScan.
 * 
 * Java 17 Compliance Notes:
 * - Compatible with Java 17 runtime environment (LTS version).
 * - No module-info.java is present; the project uses the classpath mode for simplicity.
 * - Spring Boot version mapping: Assumes Spring Boot 2.7+ for full Java 17 support.
 * - Sealed classes and records can be utilized in future enhancements if needed, but preserved
 *   existing structure here.
 * 
 * Runtime Environment Validation:
 * - Ensure JAVA_HOME points to JDK 17.
 * - Maven/Gradle build tool should specify <java.version>17</java.version> in pom.xml/build.gradle.
 * 
 * Integration Notes:
 * - Scans for components in com.amock.helloazure and subpackages (e.g., controller).
 * - Integrates seamlessly with existing TestController and HelloAzureApplicationTests.
 * - No custom plugins or configs altered; preserved zero-LOC placeholders if any.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        try {
            // Standard Spring Boot application startup
            SpringApplication.run(HelloAzureApplication.class, args);
        } catch (Exception e) {
            // Basic error handling for startup failures (e.g., configuration issues)
            System.err.println("Failed to start HelloAzureApplication: " + e.getMessage());
            e.printStackTrace();
            System.exit(1); // Exit with error code on failure
        }
    }
}