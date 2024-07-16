# Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copy the project files
COPY user-journal/pom.xml .
# COPY usesr-journal/src ./src

# Build the application
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Set the startup command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]