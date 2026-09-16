# springboot-azure-app-service

Sample Hello world Spring Boot application to deploy on Azure App Service.

## Prerequisites

- JDK 21 installed and configured as your default Java (JAVA_HOME pointing to a JDK 21 installation)
- Maven 3.6+ installed

> Note: The project currently uses Spring Boot 2.1.4.RELEASE, which is not officially certified for Java 21 but works for this demo. For production workloads on Java 21, consider upgrading to a newer Spring Boot 2.7.x or 3.x release.

## Build and run locally

```bash
mvn clean install
java -jar target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar
```

By default the app starts on port 8080. A basic smoke test is to open:

- http://localhost:8080/

## Deploying to Azure App Service

The `azure-webapp-maven-plugin` in `pom.xml` and the GitHub Actions workflow
`.github/workflows/main_kalyan-test-app-service-springboot-hello-world.yml`
are configured to build with JDK 21 and deploy the generated JAR to Azure App Service.
