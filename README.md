# springboot-azure-app-service
Sample Hello world springboot application to deploy on Azure App Service

## Requirements
- Java 21 (JDK)
- Maven (wrapper included)

## Build
```bash
./mvnw clean verify
```

## Run
```bash
./mvnw spring-boot:run
```

## Notes
- Upgraded to Spring Boot 3.3.3 (supports Java 21)
- Target Java version: 21
- CI and Azure runtime configured for Java 21
