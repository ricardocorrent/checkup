FROM openjdk:14-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dserver.port=${SERVER_PORT}","-Xmx512m","/app.jar"]