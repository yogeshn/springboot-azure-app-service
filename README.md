# springboot-azure-app-service
Sample Hello world springboot application to deploy on Azure App Service

## Requirements
- Java 21 (JDK 21)
- Maven

## Build and Run
```bash
mvn clean package
java -jar target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar
```

The application listens on port 9093 by default (see `src/main/resources/application.properties`).

## Notes
- Upgraded to Spring Boot 3.3.x and Java 21 for modern LTS support.
- Backward-compatible public API endpoints preserved.
