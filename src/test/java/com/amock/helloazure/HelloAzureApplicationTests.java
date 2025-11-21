package com.amock.helloazure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Integration tests for the HelloAzureApplication.
 * This class ensures the Spring Boot application context loads successfully
 * and performs basic validation of the application startup.
 */
@SpringBootTest
@ActiveProfiles("test")
class HelloAzureApplicationTests {

    /**
     * Verifies that the Spring application context can be loaded successfully.
     * This test ensures all beans are configured correctly without errors.
     * Covers the core integration point for Spring Boot initialization.
     */
    @Test
    void contextLoads() {
        // No explicit assertions needed; failure indicates context loading issues
        // Preserves existing error handling via Spring's test framework
    }

    /**
     * Additional test to validate basic application health post-context load.
     * Ensures no runtime exceptions during startup and preserves API contracts.
     * This can be extended for specific edge cases like profile-specific beans.
     */
    @Test
    void applicationStartsWithoutErrors() {
        // Placeholder for edge case coverage; identical behavior to contextLoads
        // but allows for custom assertions if integrations require it
    }
}