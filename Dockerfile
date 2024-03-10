FROM bellsoft/liberica-openjdk-alpine-musl:17

COPY . /usr/src/desafio-exacta

WORKDIR /usr/src/desafio-exacta

RUN apk update && \
    apk add maven && \
    mvn package

ADD target/desafio-exacta-0.0.1-SNAPSHOT.jar /usr/app

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar desafio-exacta-0.0.1-SNAPSHOT.jar"]
