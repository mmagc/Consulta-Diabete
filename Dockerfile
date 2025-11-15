# === STAGE 1: build ===
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o pom e faz download das dependências (cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código e faz o build
COPY src ./src
RUN mvn clean package -DskipTests

# === STAGE 2: runtime ===
FROM eclipse-temurin:21-jre
WORKDIR /app

# copia o jar gerado
COPY --from=build /app/target/*.jar app.jar

# Render usa a env PORT, então vamos respeitar
ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
