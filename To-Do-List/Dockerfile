# Construccion de la aplicacion
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Ejecucion de la aplicacion
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
LABEL authors="delaostia"
ENTRYPOINT ["java", "-jar", "app.jar"]