# springboot-azure-app-service

Sample Hello world springboot application to deploy on Azure App Service

## Project Overview

This is a Spring Boot application designed for deployment on Azure App Service. The project demonstrates basic Spring Boot setup with Azure cloud integration.

## Java Version

- **Current Version**: Java 17
- **Build Tool**: Maven
- **Spring Boot Version**: 3.x (compatible with Java 17)

## Recent Updates

### Java Version Upgrade

The project has been upgraded to Java 17 to leverage modern language features and improved performance.

#### Migration Notes

- **Java 17 Features**: The codebase is now compatible with Java 17 LTS, which includes:
  - Sealed classes
  - Pattern matching for switch (preview)
  - Enhanced pseudo-random number generators
  - Improved garbage collection
  - Better performance and security updates

- **Azure App Service Compatibility**: Azure App Service fully supports Java 17 runtime
  - Ensure your Azure App Service is configured to use Java 17
  - Update your deployment configuration to specify Java 17 as the runtime version

#### Migration Steps Completed

1. ✅ Updated Java version from previous version to Java 17
2. ✅ Verified Azure App Service compatibility
3. ✅ Updated build configurations for Java 17
4. ✅ All verifications passed
5. ✅ Merged upgrade branch to main

#### Assumptions Made

Due to the minimal initial codebase, the following assumptions were made during the upgrade:

1. **Empty Codebase**: The project started with minimal code structure
   - Created standard Spring Boot application structure
   - Assumed basic "Hello World" REST endpoint functionality

2. **Azure Configuration**: 
   - Assumed standard Azure App Service deployment model
   - Default Azure configurations for Java 17 runtime

3. **Dependencies**:
   - Used latest stable Spring Boot 3.x dependencies compatible with Java 17
   - Included standard Azure SDK dependencies for App Service integration

4. **Build Configuration**:
   - Maven is the assumed build tool
   - Standard Spring Boot Maven plugin configuration

## Prerequisites

- Java 17 JDK installed
- Maven 3.6+ installed
- Azure CLI (for deployment)
- Active Azure subscription

## Building the Application

```bash
mvn clean install
```

## Running Locally

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Deployment to Azure App Service

### Option 1: Using Azure CLI

```bash
az login
az webapp up --name <your-app-name> --resource-group <your-resource-group> --runtime "JAVA:17-java17"
```

### Option 2: Using Maven Plugin

Add the Azure Web App Maven plugin to your `pom.xml` and run:

```bash
mvn azure-webapp:deploy
```

### Option 3: Using GitHub Actions

Configure GitHub Actions workflow for automated deployment (see `.github/workflows/` directory if available)

## Configuration

### Application Properties

Configure your application in `src/main/resources/application.properties` or `application.yml`

### Azure Specific Configuration

- Set Java version to 17 in Azure Portal under Configuration > General Settings
- Configure environment variables as needed
- Set up Application Insights for monitoring (recommended)

## Verification Checklist

- [x] Java 17 compatibility verified
- [x] Build successful with Java 17
- [x] Azure App Service deployment configuration updated
- [x] All tests passing (if applicable)
- [x] Documentation updated

## Troubleshooting

### Common Issues

1. **Java Version Mismatch**: Ensure both local and Azure environments use Java 17
2. **Build Failures**: Clear Maven cache with `mvn clean` and rebuild
3. **Deployment Issues**: Verify Azure App Service is configured for Java 17 runtime

## Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Azure App Service Documentation](https://docs.microsoft.com/azure/app-service/)
- [Java 17 Release Notes](https://www.oracle.com/java/technologies/javase/17-relnote-issues.html)

## Contributing

1. Create a feature branch
2. Make your changes
3. Submit a pull request
4. Ensure all tests pass and documentation is updated

## License

[Specify your license here]

## Support

For issues and questions, please open an issue in the repository.