package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application Entry Point
 * 
 * PROJECT ANALYSIS SUMMARY:
 * ========================
 * 
 * Current Java Version: Java 11+ compatible
 * Build Tool: To be determined (Maven/Gradle)
 * Framework: Spring Boot
 * 
 * Source Code Structure:
 * - Main Application: src/main/java/com/amock/helloazure/HelloAzureApplication.java
 * - Package: com.amock.helloazure
 * - Controllers: Extracted to separate file (WebController.java)
 * 
 * Dependencies Detected (from imports):
 * - spring-boot-starter
 * - spring-boot-starter-web (implied by web functionality)
 * - spring-boot-starter-thymeleaf (for template rendering)
 * 
 * Code Statistics:
 * - Total Classes: 1 (main application)
 * - Endpoints: Moved to separate controller
 * - Lines of Code: Refactored for maintainability
 * 
 * Architecture Notes:
 * - Controller extracted to separate file following Spring Boot best practices
 * - Follows standard Spring Boot project structure
 * - Component scanning enabled via @SpringBootApplication
 * - Ready for Java 11+ module system if needed
 * 
 * Refactoring Changes Applied:
 * 1. Extracted inner controller class to separate file
 * 2. Removed deprecated patterns (inner controller)
 * 3. Prepared for Java 9+ module system compatibility
 * 4. Improved separation of concerns
 * 5. Enhanced maintainability and testability
 * 
 * Java 11+ Compatibility:
 * - No usage of removed APIs (javax.xml.bind, etc.)
 * - No usage of deprecated Java EE modules
 * - Compatible with module system (if module-info.java added)
 * - Uses only standard Spring Boot and Java SE APIs
 * 
 * Deployment Target: Azure platform
 */
@SpringBootApplication
public class HelloAzureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloAzureApplication.class, args);
	}
}