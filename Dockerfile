# Step 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

# Step 2: Run
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# IMPORTANT: use exec form (no shell issues)
ENTRYPOINT ["java","-jar","app.jar"]