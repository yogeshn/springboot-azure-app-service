package com.amock.helloazure;

// Import Spring Boot annotations and classes for application bootstrap.
// Using Spring Boot 3.x or compatible for Java 17 support, ensuring efficient startup and resource management.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * HelloAzureApplication is the main entry point for the Spring Boot application.
 * This class initializes the application context, enabling features like dependency injection,
 * auto-configuration, and component scanning for efficient performance in Java 17.
 * 
 * Key logic:
 * - The @SpringBootApplication annotation combines @Configuration, @EnableAutoConfiguration, and @ComponentScan,
 *   optimizing startup by automatically configuring beans and scanning for components.
 * - The main method runs the Spring Application, handling command-line arguments and ensuring the application
 *   starts successfully. Error handling is delegated to Spring's robust exception management.
 * - For Java 17 compatibility, the code uses standard Java features without deprecated APIs, promoting efficiency
 *   and reducing overhead in modern JVM environments.
 * - Edge cases: If no args are provided, SpringApplication defaults to standard behavior; invalid configurations
 *   are managed via Spring's validation mechanisms.
 */
@SpringBootApplication
public class HelloAzureApplication {

    /**
     * Main method to launch the Spring Boot application.
     * This method is optimized for quick startup, leveraging Java 17's improved garbage collection and performance.
     * 
     * @param args command-line arguments passed to the application (e.g., profile overrides).
     *             If args is null, an empty array is assumed, ensuring no NullPointerException.
     */
    public static void main(String[] args) {
        // Run the Spring Boot application, passing the application class and args.
        // SpringApplication handles edge cases like invalid args or startup failures internally.
        SpringApplication.run(HelloAzureApplication.class, args != null ? args : new String[0]);
    }
}