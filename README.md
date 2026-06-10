# springboot-azure-app-service

Sample hello world Spring Boot application to deploy on Azure App Service.

## Prerequisites

- Java 21 (Temurin or any compatible distribution)
- Maven 3.9+

## Build and Test

```bash
mvn clean verify
```

The Maven build compiles the project using Java 21 and executes the Spring Boot test suite. Deploy the generated JAR from `target/` to your preferred environment or use the provided Azure pipeline/workflow for automation.
