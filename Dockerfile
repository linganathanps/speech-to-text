FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_FILE=target/voice-to-text.jar

WORKDIR /opt/app

COPY ./cert.p12 /opt/app

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]