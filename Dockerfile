FROM openjdk:14-jdk-alpine
MAINTAINER Ricardo Corrent
ADD target/checkup.jar checkup.jar
EXPOSE 8083
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /checkup.jar"]