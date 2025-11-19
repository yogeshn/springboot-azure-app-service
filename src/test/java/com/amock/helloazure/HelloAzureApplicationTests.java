package com.amock.helloazure;

import com.amock.helloazure.controller.TestController;
import com.amock.helloazure.model.MyName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Smoke tests for HelloAzureApplication.
 * Verifies Spring Boot application startup and basic context loading.
 * Includes integration tests for controller endpoints to ensure basic functionality.
 * Compatible with Java 17+ features and Maven builds.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test") // Use test profile if needed for configurations
class HelloAzureApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TestController testController;

    /**
     * Basic smoke test to verify Spring Boot context loads successfully.
     * Ensures the application starts without errors and beans are available.
     */
    @Test
    void contextLoads() {
        // This test passes if the context loads without exceptions
        assertThat(testController).isNotNull();
    }

    /**
     * Integration test for TestController's basic GET endpoint.
     * Verifies the endpoint is accessible and returns expected response.
     * Includes error handling for connection issues.
     */
    @Test
    void testControllerBasicEndpoint() {
        try {
            URL url = new URL("http://localhost:" + port + "/test/hello");
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(response.getBody()).contains("Hello"); // Basic assertion on response
        } catch (Exception e) {
            // Log and fail if connection or unexpected error occurs
            throw new RuntimeException("Failed to connect to test endpoint", e);
        }
    }

    /**
     * Integration test for TestController's endpoint with MyName model.
     * Verifies JSON serialization/deserialization and edge cases like null inputs.
     * Ensures robustness against invalid requests.
     */
    @Test
    void testControllerMyNameEndpoint() {
        try {
            // Test with valid MyName object
            MyName validName = new MyName("John", "Doe");
            URL validUrl = new URL("http://localhost:" + port + "/test/name?firstName=John&lastName=Doe");
            ResponseEntity<MyName> validResponse = restTemplate.getForEntity(validUrl, MyName.class);

            assertThat(validResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(validResponse.getBody()).isNotNull();
            assertThat(validResponse.getBody().getFirstName()).isEqualTo("John");
            assertThat(validResponse.getBody().getLastName()).isEqualTo("Doe");

            // Edge case: Test with empty names (if endpoint handles gracefully)
            URL emptyUrl = new URL("http://localhost:" + port + "/test/name?firstName=&lastName=");
            ResponseEntity<MyName> emptyResponse = restTemplate.getForEntity(emptyUrl, MyName.class);

            assertThat(emptyResponse.getStatusCode()).isEqualTo(HttpStatus.OK); // Assuming endpoint allows empty strings
            assertThat(emptyResponse.getBody()).isNotNull();
            assertThat(emptyResponse.getBody().getFirstName()).isEmpty();
            assertThat(emptyResponse.getBody().getLastName()).isEmpty();

            // Edge case: Test with missing parameters (expect 400 or handled gracefully)
            URL missingUrl = new URL("http://localhost:" + port + "/test/name?firstName=Jane");
            ResponseEntity<String> missingResponse = restTemplate.getForEntity(missingUrl, String.class);

            assertThat(missingResponse.getStatusCode()).isGreaterThanOrEqualTo(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Handle network or parsing errors
            throw new RuntimeException("Failed to test MyName endpoint", e);
        }
    }

    /**
     * Smoke test for compilation and runtime validation under new Java version.
     * Verifies no compatibility issues with Java 17+ (e.g., records, switch expressions if used).
     * This is a placeholder for any Java version-specific assertions.
     */
    @Test
    void validateJavaVersionCompatibility() {
        // Basic check for Java version at runtime (ensures Maven build targets correctly)
        String javaVersion = System.getProperty("java.version");
        assertThat(javaVersion).startsWith("17"); // Adjust if targeting different version, e.g., "21"

        // Test a Java 17+ feature if applicable (e.g., sealed classes or pattern matching, but keep minimal)
        // For now, just ensure no ClassNotFound or UnsupportedClassVersionError during context load
        assertThat(testController).isNotNull(); // Reuse bean availability as proxy for compatibility
    }
}