FROM openjdk:17-alpine

WORKDIR /usr/src/exacta

COPY target/exacta.jar ./exacta.jar

CMD ["java", "-jar", "exacta.jar"]
