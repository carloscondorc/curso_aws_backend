FROM openjdk:8-jdk-alpine
LABEL maintainer="w.marchanaranda@gmail.com"
WORKDIR /workspace
COPY target/comp*.jar app.jar
#ENV JAVA_OPTS=""
#ENV userPoolId="us-east-1_3ywspb2fX"
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /workspace/app.jar
EXPOSE 8080