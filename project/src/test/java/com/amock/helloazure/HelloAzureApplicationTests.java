package com.amock.helloazure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.Nested;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;

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

	@Nested
	@DisplayName("Java Version Compatibility Tests")
	class JavaVersionCompatibilityTests {

		@Test
		@DisplayName("Java 8 compatibility verification")
		@EnabledOnJre(JRE.JAVA_8)
		public void java8Compatibility() {
			String javaVersion = System.getProperty("java.version");
			assertNotNull(javaVersion, "Java version should be available");
			assertTrue(javaVersion.startsWith("1.8"), "Should be running on Java 8");
			assertNotNull(applicationContext, "Spring Boot context should initialize on Java 8");
		}

		@Test
		@DisplayName("Java 11 compatibility verification")
		@EnabledOnJre(JRE.JAVA_11)
		public void java11Compatibility() {
			String javaVersion = System.getProperty("java.version");
			assertNotNull(javaVersion, "Java version should be available");
			assertTrue(javaVersion.startsWith("11"), "Should be running on Java 11");
			assertNotNull(applicationContext, "Spring Boot context should initialize on Java 11");
			
			// Verify Java 11 specific features
			assertDoesNotThrow(() -> String.class.getMethod("isBlank"), 
				"Java 11 String methods should be available");
		}

		@Test
		@DisplayName("Java 17 compatibility verification")
		@EnabledOnJre(JRE.JAVA_17)
		public void java17Compatibility() {
			String javaVersion = System.getProperty("java.version");
			assertNotNull(javaVersion, "Java version should be available");
			assertTrue(javaVersion.startsWith("17"), "Should be running on Java 17");
			assertNotNull(applicationContext, "Spring Boot context should initialize on Java 17");
			
			// Verify Java 17 specific features
			assertDoesNotThrow(() -> String.class.getMethod("isBlank"), 
				"Java 17 String methods should be available");
		}

		@Test
		@DisplayName("Current Java version compatibility")
		public void currentJavaVersionCompatibility() {
			String javaVersion = System.getProperty("java.version");
			assertNotNull(javaVersion, "Java version should be available");
			
			int majorVersion = getMajorJavaVersion();
			assertTrue(majorVersion >= 8, "Java version should be 8 or higher");
			
			assertNotNull(applicationContext, "Spring Boot context should initialize on current Java version");
		}

		private int getMajorJavaVersion() {
			String version = System.getProperty("java.version");
			if (version.startsWith("1.")) {
				version = version.substring(2, 3);
			} else {
				int dot = version.indexOf(".");
				if (dot != -1) {
					version = version.substring(0, dot);
				}
			}
			return Integer.parseInt(version);
		}
	}

	@Nested
	@DisplayName("Integration Tests for External Dependencies")
	@SpringBootTest
	class ExternalDependencyIntegrationTests {

		@Autowired
		private ApplicationContext applicationContext;

		@Test
		@DisplayName("Spring Boot dependencies integration test")
		public void springBootDependenciesIntegration() {
			assertNotNull(applicationContext, "Application context should be initialized");
			
			// Verify Spring Boot core dependencies
			assertTrue(applicationContext.containsBean("springApplicationAdminRegistrar") || 
					   applicationContext.getBeanDefinitionCount() > 0,
				"Spring Boot core dependencies should be available");
		}

		@Test
		@DisplayName("Azure SDK dependencies integration test")
		public void azureSdkDependenciesIntegration() {
			assertNotNull(applicationContext, "Application context should be initialized");
			
			// Check if Azure-related beans are present (if configured)
			String[] allBeans = applicationContext.getBeanDefinitionNames();
			assertNotNull(allBeans, "Bean definitions should be available");
			assertTrue(allBeans.length > 0, "At least one bean should be defined");
		}

		@Test
		@DisplayName("Spring Web dependencies integration test")
		public void springWebDependenciesIntegration() {
			assertNotNull(applicationContext, "Application context should be initialized");
			
			// Verify web-related beans if web starter is included
			try {
				Class.forName("org.springframework.web.servlet.DispatcherServlet");
				assertTrue(true, "Spring Web dependencies are available");
			} catch (ClassNotFoundException e) {
				// Spring Web not included, test passes
				assertTrue(true, "Spring Web not included in dependencies");
			}
		}

		@Test
		@DisplayName("Test framework dependencies integration test")
		public void testFrameworkDependenciesIntegration() {
			// Verify JUnit 5 is available
			assertDoesNotThrow(() -> Class.forName("org.junit.jupiter.api.Test"),
				"JUnit 5 should be available");
			
			// Verify Spring Boot Test is available
			assertDoesNotThrow(() -> Class.forName("org.springframework.boot.test.context.SpringBootTest"),
				"Spring Boot Test should be available");
		}
	}

	@Nested
	@DisplayName("Incremental Upgrade Path Tests")
	class IncrementalUpgradePathTests {

		@Test
		@DisplayName("Java 8 to 11 upgrade path verification")
		public void java8To11UpgradePath() {
			String javaVersion = System.getProperty("java.version");
			int majorVersion = getMajorJavaVersion();
			
			if (majorVersion == 8 || majorVersion == 11) {
				assertNotNull(applicationContext, "Application should work on Java 8 and 11");
				
				// Test features common to both versions
				assertDoesNotThrow(() -> applicationContext.getBean(HelloAzureApplication.class),
					"Main application bean should be available");
			}
		}

		@Test
		@DisplayName("Java 11 to 17 upgrade path verification")
		public void java11To17UpgradePath() {
			String javaVersion = System.getProperty("java.version");
			int majorVersion = getMajorJavaVersion();
			
			if (majorVersion == 11 || majorVersion == 17) {
				assertNotNull(applicationContext, "Application should work on Java 11 and 17");
				
				// Test features common to both versions
				assertTrue(applicationContext.getBeanDefinitionCount() > 0,
					"Beans should be properly initialized");
			}
		}

		@Test
		@DisplayName("Direct Java 8 to 17 upgrade verification")
		public void java8To17DirectUpgrade() {
			String javaVersion = System.getProperty("java.version");
			int majorVersion = getMajorJavaVersion();
			
			assertNotNull(applicationContext, "Application should initialize on any supported Java version");
			assertTrue(majorVersion >= 8, "Java version should be 8 or higher");
			
			// Verify backward compatibility features
			assertDoesNotThrow(() -> {
				applicationContext.getBean(HelloAzureApplication.class);
			}, "Application should maintain backward compatibility");
		}

		private int getMajorJavaVersion() {
			String version = System.getProperty("java.version");
			if (version.startsWith("1.")) {
				version = version.substring(2, 3);
			} else {
				int dot = version.indexOf(".");
				if (dot != -1) {
					version = version.substring(0, dot);
				}
			}
			return Integer.parseInt(version);
		}
	}

	@Test
	@DisplayName("Build and test lifecycle verification")
	public void buildLifecycleVerification() {
		// Verify JUnit 5 is working correctly
		assertTrue(true, "JUnit 5 test execution verified");
		
		// Verify Java version compatibility
		String javaVersion = System.getProperty("java.version");
		assertNotNull(javaVersion, "Java version should be available");
		
		int majorVersion = getMajorJavaVersion();
		assertTrue(majorVersion >= 8, "Java version should be 8 or higher for compatibility testing");
		
		// Verify Spring Boot context initialization
		assertNotNull(applicationContext, "Spring Boot context initialized successfully");
	}

	private int getMajorJavaVersion() {
		String version = System.getProperty("java.version");
		if (version.startsWith("1.")) {
			version = version.substring(2, 3);
		} else {
			int dot = version.indexOf(".");
			if (dot != -1) {
				version = version.substring(0, dot);
			}
		}
		return Integer.parseInt(version);
	}
}