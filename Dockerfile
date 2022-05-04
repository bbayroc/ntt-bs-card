FROM amazoncorretto:11-alpine-jdk
MAINTAINER bayro
COPY target/Card-0.0.1-SNAPSHOT.jar /Card.jar
ENTRYPOINT ["java","-jar","/Card.jar"]

