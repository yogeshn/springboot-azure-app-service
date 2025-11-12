package com.amock.helloazure.model;

/**
 * Model class representing a person's name.
 * 
 * Project Analysis Notes:
 * - Package structure: com.amock.helloazure.model (standard Maven/Gradle layout)
 * - Java version: Unknown (requires pom.xml/build.gradle examination)
 * - Build tool: Likely Maven or Gradle (based on src/main/java structure)
 * - Dependencies: None evident in this POJO
 * - Code style: Standard JavaBean with no-arg constructor, parameterized constructor, getters/setters
 * - Java features used: Basic (compatible with Java 1.4+)
 * 
 * Assumptions for Upgrade Scope:
 * - Project follows standard Maven/Gradle directory structure
 * - This is a simple POJO with no external dependencies
 * - No modern Java features (records, annotations, etc.) currently used
 * - Likely candidates for upgrade: Java 8+ features (Optional, Stream API), Java 14+ records
 * - Build configuration files need examination to determine exact Java version and dependencies
 */
public class MyName {

	private String firstName;
	private String lastName;
	
	public MyName() {
		super();
	}

	public MyName(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}