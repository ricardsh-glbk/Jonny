FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline  # Fixed: changed "maven" to "mvn"

COPY src ./src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Копируем собранный jar из этапа builder
COPY --from=builder /app/target/*.jar app.jar

# Переменная окружения (передаётся при запуске)

# Порт, который слушает Spring Boot
EXPOSE 8080

# Команда запуска
ENTRYPOINT ["java", "-jar", "app.jar"]

