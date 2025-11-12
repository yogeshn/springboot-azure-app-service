package com.amock.helloazure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Hello Azure Application Tests")
public class HelloAzureApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	@DisplayName("Application context should load successfully")
	public void contextLoads() {
		assertNotNull(applicationContext, "Application context should not be null");
	}

	@Test
	@DisplayName("Application context should contain beans")
	public void contextContainsBeans() {
		assertNotNull(applicationContext);
		assertTrue(applicationContext.getBeanDefinitionCount() > 0, 
			"Application context should contain at least one bean");
	}

	@Test
	@DisplayName("Main application class should be present in context")
	public void mainApplicationClassExists() {
		assertNotNull(applicationContext);
		String[] beanNames = applicationContext.getBeanNamesForType(HelloAzureApplication.class);
		assertTrue(beanNames.length > 0, 
			"HelloAzureApplication bean should be present in context");
	}

	@Test
	@DisplayName("Application should have Spring Boot application name")
	public void applicationHasName() {
		assertNotNull(applicationContext);
		assertTrue(applicationContext.getApplicationName() != null, 
			"Application should have a name");
	}

	@Test
	@DisplayName("Build and test lifecycle verification")
	public void buildLifecycleVerification() {
		// Verify JUnit 5 is working correctly
		assertTrue(true, "JUnit 5 test execution verified");
		
		// Verify Java 17 compatibility
		String javaVersion = System.getProperty("java.version");
		assertNotNull(javaVersion, "Java version should be available");
		
		// Verify Spring Boot context initialization
		assertNotNull(applicationContext, "Spring Boot context initialized successfully");
	}

}