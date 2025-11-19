package com.amock.helloazure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Integration tests for the HelloAzureApplication.
 * This class verifies that the Spring Boot application context loads successfully.
 * No additional assertions are needed beyond context initialization for basic validation.
 */
@SpringBootTest
class HelloAzureApplicationTests {

    /**
     * Tests that the Spring application context can be loaded without errors.
     * This ensures overall application wiring, dependency injection, and configuration are correct.
     * Runtime behavior is validated implicitly through context startup.
     */
    @Test
    void contextLoads() {
        // No explicit assertions; success is indicated by the test passing without exceptions.
        // This covers the core functionality of starting the application.
    }
}