# springboot-azure-app-service
Sample Hello world Spring Boot application to deploy on Azure App Service.

## Requirements
- Java 21 (Temurin recommended)
- Maven 3.8+

## Build and run
- Build: `mvn clean package`
- Test: `mvn test`
- Run locally: `mvn spring-boot:run`

## Azure
- The app is configured to run on Java 21 in Azure App Service.
- Azure sets `JAVA_OPTS=-Dserver.port=80` for the Linux deployment target.
