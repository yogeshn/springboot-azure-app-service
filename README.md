# springboot-azure-app-service
Sample Hello world springboot application to deploy on Azure App Service

## Requirements
- Java 21 (JDK 21)
- Maven 3.9+

## Build and Run
```bash
mvn clean package
java -jar target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar
```

> Note: If the Maven wrapper (`./mvnw`) is fully set up in your environment, you may use `./mvnw clean package` instead. The project is configured for Java 21.

## Endpoints
- `/` - Home page
- `/test` - Returns "Hello Kalyan. This is version 2"
- `/test2` - Returns "Hello Kalyan2"
- `POST /testpost` - Echoes JSON body as MyName
