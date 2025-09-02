
FROM openjdk:11-jdk-slim

WORKDIR /app
copy target/spring-boot-sql-server-0.0.1-SNAPSHOT.jar /app/spring-boot-sql-server.jar
expose 3000
CMD ["java", "-jar", "/app/spring-boot-sql-server.jar"]
