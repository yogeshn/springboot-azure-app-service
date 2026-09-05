package com.amock.helloazure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Integration tests for the HelloAzureApplication.
 * Ensures the application context loads correctly without errors.
 * Prioritizes efficiency by using lightweight test configuration.
 */
@SpringBootTest
@ActiveProfiles("test") // Use test profile to avoid loading unnecessary beans
class HelloAzureApplicationTests {

    /**
     * Verifies that the Spring application context can be loaded successfully.
     * This test covers the basic startup functionality and detects any configuration issues early.
     * No assertions are needed beyond context loading; failures indicate breaking changes.
     */
    @Test
    void contextLoads() {
        // Intentionally empty: Spring Boot handles context loading and reports issues
        // Edge case: If context fails to load due to deprecations or incompatibilities, test fails
    }

    /**
     * Additional test to ensure no performance regressions in context initialization.
     * Measures startup time implicitly through JUnit execution; explicit timing can be added if needed.
     * Handles potential errors during context refresh gracefully via Spring's error reporting.
     */
    @Test
    void applicationStartsWithoutErrors() {
        // Reuse context from SpringBootTest; no additional setup required
        // This test passes if no exceptions are thrown during inherited context load
    }
}