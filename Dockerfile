FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/api-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
