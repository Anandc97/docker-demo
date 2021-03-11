FROM openjdk:8-jdk-alpine
WORKDIR /demo-service
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
