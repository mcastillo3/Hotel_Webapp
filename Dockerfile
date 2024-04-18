FROM openjdk:17-jdk-alpine
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/myApp.jar
EXPOSE 8080 4200
ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["java", "-jar", "/app/myApp.jar"]