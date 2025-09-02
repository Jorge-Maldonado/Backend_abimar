# Stage 1: Build the jar using Maven
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app

# Copiar archivos de configuración y código fuente
COPY pom.xml .
COPY src ./src

# Construir el proyecto (sin tests para acelerar)
RUN mvn clean package -DskipTests

# Stage 2: Ejecutar la app con OpenJDK
FROM openjdk:11-jdk-slim
WORKDIR /app

# Copiar el .jar generado en la etapa build
COPY --from=build /app/target/spring-boot-sql-server-0.0.1-SNAPSHOT.jar ./spring-boot-sql-server.jar

# Exponer el puerto (cambia si tu app usa otro)
EXPOSE 3000

# Comando para arrancar la app
CMD ["java", "-jar", "spring-boot-sql-server.jar"]
