# Use Java 21
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

# Install Maven
RUN apk add --no-cache maven bash

# Copy Maven files
COPY pom.xml .
COPY src ./src

# Build the Spring Boot app
RUN mvn clean package -DskipTests

# Use a smaller image for running
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
