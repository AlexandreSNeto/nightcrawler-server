FROM openjdk:11-jdk

MAINTAINER Alexandre Silveira Neto <alexandre.sneto@gmail.com>

ARG APPLICATION_NAME
ARG VERSION

ENV TZ=America/Sao_Paulo

ADD target/$APPLICATION_NAME-$VERSION.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]