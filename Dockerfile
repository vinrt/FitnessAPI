FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
USER root
RUN mkdir /opt/fitness-api
WORKDIR /opt
COPY ${JAR_FILE} /opt/fitness-api/fitness-api.jar

EXPOSE 8080
#Commented this code for k8s
#CMD ["java", "-jar", "fitness-api/fitness-api.jar"]