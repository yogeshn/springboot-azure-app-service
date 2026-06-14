# springboot-azure-app-service

Sample Spring Boot "Hello World" application that can be deployed to Azure App Service.

## Prerequisites
- **Java Development Kit:** Temurin/Microsoft Build of OpenJDK **21** or newer. The project no longer supports Java 8.
- **Maven:** 3.9.x or newer.

Verify your local toolchain with:

```bash
java -version
mvn -v
```

Both commands should report Java 21 before building or testing.

## Build & Test
Compile and run the automated test suite locally with:

```bash
mvn clean verify
```

The GitHub Actions workflow (`.github/workflows/main_kalyan-test-app-service-springboot-hello-world.yml`) uses the same command on Ubuntu runners with Java 21 to ensure CI parity.

## Running Locally
1. Build the executable jar: `mvn clean package`
2. Start the app: `java -jar target/springboot-azure-app-service-0.0.1-SNAPSHOT.jar`
3. Access the following endpoints while running on Java 21:
   - `/` – Thymeleaf index page
   - `/test`, `/test2` – basic text responses
   - `/testpost` – sample POST echo endpoint

## Deployment Notes
- The Maven `azure-webapp-maven-plugin` is configured to deploy to an Azure Linux Web App using the **Java 21** runtime (`Java SE`).
- The repo retains `web.config` to document the equivalent Windows App Service startup command; it has been verified to work with Java 21 by referencing `%JAVA_HOME%` at runtime.
- Update the `subscriptionId`, `resourceGroup`, or `appName` inside `pom.xml` before publishing to a different environment.

### Legacy Azure Pipelines
`sprintboot-azure-app-service-azure-pipeline.yml` and `kalyan-test-simple-springboot-azure-pipelines.yml` are illustrative samples only. They are not wired into CI/CD. If you enable them, ensure the hosted agent installs Java 21 (for example by adding a `UseJavaVersion@1` step or `actions/setup-java` equivalent).

## Smoke Testing
After deploying (locally or to Azure), perform quick smoke tests against the endpoints listed above to ensure they respond without Java-version-related errors.
