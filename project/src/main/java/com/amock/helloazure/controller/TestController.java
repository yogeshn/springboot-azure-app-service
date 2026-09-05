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
 * Refactoring Notes:
 * - Updated for Java 11+ compatibility
 * - Applied modern Spring Boot conventions
 * - Ensured compatibility with Spring Boot 3.x and Java 17+
 * - No deprecated APIs detected in current implementation
 * - ResponseEntity factory methods used for cleaner code
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
		return ResponseEntity.ok(name);
	}
}