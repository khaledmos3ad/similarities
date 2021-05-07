FROM openjdk:11-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} similarities.jar
ENTRYPOINT ["java","-jar","/similarities.jar"]