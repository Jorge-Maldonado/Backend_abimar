# Etapa de construcción
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

# Copiamos todo el proyecto y lo construimos
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiamos el JAR desde la etapa build
COPY --from=build /app/target/*.jar ./app.jar

# Exponer el puerto (cámbialo si usas otro)
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]
