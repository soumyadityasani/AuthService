# Stage 1: Build with Java 21
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

# Make Maven wrapper executable
RUN chmod +x ./mvnw

# Build project, skip tests
RUN ./mvnw -B -DskipTests clean package

# Stage 2: Run with Java 21 JRE
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Start your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
