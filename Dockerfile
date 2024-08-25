FROM openjdk:23-ea-17-jdk-bullseye
WORKDIR /app
COPY target/testtask-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]