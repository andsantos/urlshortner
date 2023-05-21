FROM eclipse-temurin:17-jdk-alpine
# EXPOSE 8080
# VOLUME /var/log/app
RUN apk update && apk add --update curl
CMD /bin/bash
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=test"]
ENTRYPOINT ["java","-jar","/app.jar"]
