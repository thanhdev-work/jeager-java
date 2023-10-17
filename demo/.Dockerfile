FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/api-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/application.jar"]