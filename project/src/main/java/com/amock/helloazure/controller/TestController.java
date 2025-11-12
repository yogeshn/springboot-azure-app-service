package com.amock.helloazure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amock.helloazure.model.MyName;

/**
 * REST Controller for test endpoints
 * 
 * Project Analysis Notes:
 * - Java Version: Unable to determine from source code alone (requires pom.xml/build.gradle)
 * - Build Tool: Unknown (requires build configuration files)
 * - Framework: Spring Boot (based on annotations)
 * - Dependencies Identified:
 *   * spring-boot-starter-web (RestController, RequestMapping, GetMapping, PostMapping, ResponseEntity)
 *   * Custom model: com.amock.helloazure.model.MyName
 * 
 * Assumptions for Upgrade Scope:
 * - Project structure follows Maven/Gradle conventions (src/main/java)
 * - Likely Spring Boot 2.x or 3.x based on annotation usage
 * - Java 8+ minimum (lambda-ready syntax not used but available)
 * - Standard REST API implementation
 * - No security, database, or advanced features detected in this controller
 * 
 * Required Files to Examine:
 * - pom.xml or build.gradle (build configuration)
 * - application.properties/application.yml (runtime configuration)
 * - src/main/java/com/amock/helloazure/model/MyName.java (model class)
 * - Main application class (likely HelloazureApplication.java)
 * 
 * Project Status: NOT EMPTY - Contains functional Spring Boot REST controller
 */
@RestController
@RequestMapping("/")
public class TestController {
	
	@GetMapping("test")
	public String test() {
		return "Hello Kalyan. This is version 2";
	}
	
	@GetMapping("test2")
	public String test2() {
		return "Hello Kalyan2";
	}

	@PostMapping("testpost")
	public ResponseEntity<MyName> testpost(@RequestBody MyName name) {
		return new ResponseEntity<MyName>(name, HttpStatus.OK);
	}
}