# Construccion de la aplicacion
FROM eclipse-temurin:21-jdk-alpine AS Builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

LABEL authors="delaostia"
ENTRYPOINT ["toubuntu:ubuntu:p", "-b"]