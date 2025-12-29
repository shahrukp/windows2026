# Step 1: Base images
FROM eclipse-temurin:17-jdk


# Step 2: Working directory in container
WORKDIR /app

# Step 3: Copy the built jar into container
COPY target/windows-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose port (Spring Boot default 8080) this is your spring boot port
EXPOSE 8084

# Step 5: Command to run jar
ENTRYPOINT ["java","-jar","app.jar"]
