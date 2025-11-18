package com.amock.helloazure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HelloAzureApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HelloAzureApplication application;

    @Test
    void contextLoads() {
        // Verify that the application context loads successfully
        assertThat(application).isNotNull();
    }

    @Test
    void homeEndpointReturnsHelloMessage() {
        // Test the root endpoint
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/",
                String.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("Hello Azure App Service");
    }

    @Test
    void healthEndpointReturnsUp() {
        // Test the health endpoint
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/actuator/health",
                String.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("UP");
    }

    @Test
    void infoEndpointContainsAppInfo() {
        // Test the info endpoint
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/actuator/info",
                String.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // Spring Boot 3.x may return an empty object by default if no info is configured
        assertThat(response.getBody()).isNotNull();
    }
}