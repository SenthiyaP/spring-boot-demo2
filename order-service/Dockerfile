#base image with java
FROM openjdk:17-jdk-slim

#set working directory inside container
WORKDIR /app

#copy the jar file(after you build with mvn package)
COPY target/*.jar app.jar

#run application
ENTRYPOINT ["java", "-jar", "app.jar"]