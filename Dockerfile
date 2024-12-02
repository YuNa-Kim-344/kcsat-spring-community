FROM bellsoft/liberica-openjdk-alpine:latest

VOLUME /tmp
#
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} KCSAT-Spring-Community.jar

ENTRYPOINT ["java", "-jar", "/KCSAT-Spring-Community.jar"]