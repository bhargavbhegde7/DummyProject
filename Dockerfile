# Multi-stage Dockerfile for building and running the Spring Boot application
FROM maven:3.9.6-eclipse-temurin-11 AS build
WORKDIR /workspace

# Copy pom.xml and download dependencies (this layer will be cached)
COPY pom.xml ./
RUN mvn -B -e -DskipTests dependency:resolve

# Copy source code and build
COPY src ./src
RUN mvn -B -e -DskipTests clean package

# Runtime stage
FROM eclipse-temurin:11-jre-jammy
WORKDIR /app

# Create a non-root user for security
RUN useradd -m -u 1000 appuser

# Spring Boot plugin repackages to target/<artifactId>-<version>.jar
COPY --from=build /workspace/target/DummyProject-1.0-SNAPSHOT.jar ./app.jar

# Set ownership to appuser
RUN chown -R appuser:appuser /app

# Switch to non-root user
USER appuser

# Expose port 8080
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
  CMD java -cp app.jar org.springframework.boot.loader.JarLauncher || exit 1

# Set JVM options for optimal Spring Boot performance
ENV JAVA_OPTS="-XX:+UseG1GC -XX:MaxRAMPercentage=75.0 -XX:InitialRAMPercentage=25.0"

# Run the Spring Boot application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar ./app.jar"]


