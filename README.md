# springboot-azure-app-service
Sample Hello world Spring Boot application to deploy on Azure App Service.

This project requires Java 21 for local development, CI, and runtime execution.

## Requirements
- Java 21
- Maven

## Build and run
- `mvn compile`
- `mvn test`
- `mvn spring-boot:run`

The application listens on port `9093` by default and logs the detected Java runtime at startup for observability.
