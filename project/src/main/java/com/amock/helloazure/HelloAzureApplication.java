package com.amock.helloazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

/**
 * Spring Boot Application Entry Point
 * 
 * PROJECT ANALYSIS SUMMARY:
 * ========================
 * 
 * Current Java Version: To be determined from pom.xml/build.gradle
 * Build Tool: To be determined (Maven/Gradle)
 * Framework: Spring Boot
 * 
 * Source Code Structure:
 * - Main Application: src/main/java/com/amock/helloazure/HelloAzureApplication.java
 * - Package: com.amock.helloazure
 * - Controllers: 1 inner controller (WebController)
 * 
 * Dependencies Detected (from imports):
 * - spring-boot-starter
 * - spring-boot-starter-web (implied by @GetMapping)
 * - Template engine (implied by return "index" - likely Thymeleaf)
 * 
 * Code Statistics:
 * - Total Classes: 2 (1 main + 1 inner controller)
 * - Endpoints: 1 GET mapping at root path
 * - Lines of Code: ~21 (excluding comments)
 * 
 * Architecture Notes:
 * - Inner controller class (non-standard, should be extracted)
 * - Returns view name "index" suggesting templates/index.html exists
 * - No explicit configuration classes
 * - No service or repository layers detected
 * 
 * Assumptions for Upgrade Scope:
 * 1. Build configuration files exist at project root (pom.xml or build.gradle)
 * 2. Template file exists at src/main/resources/templates/index.html
 * 3. Application properties may exist at src/main/resources/application.properties
 * 4. Project follows standard Maven/Gradle directory structure
 * 5. Target deployment: Azure platform (based on package name)
 * 
 * Recommended Actions Before Upgrade:
 * - Extract WebController to separate file
 * - Verify Spring Boot version compatibility
 * - Check Java version in build files
 * - Review all dependencies for upgrade compatibility
 * - Identify any Azure-specific configurations
 */
@SpringBootApplication
public class HelloAzureApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloAzureApplication.class, args);
	}

	@Controller
	class WebController {
		
		@GetMapping
		public String home(){
			return "index";
		}
	}
}