# Construccion de la aplicacion
FROM eclipse-temurin:21-jdk-alpine AS Builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Ejecucion de la aplicacion
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 5000
LABEL authors="delaostia"
ENTRYPOINT ["java", "-jar", "app.jar"]