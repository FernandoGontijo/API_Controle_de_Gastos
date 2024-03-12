FROM maven:3.8.4-openjdk-17 AS builder

COPY . /build
WORKDIR /build
RUN mvn clean package

FROM bellsoft/liberica-openjdk-alpine-musl:17

ENV APP_NAME desafio-exacta-0.0.1-SNAPSHOT

COPY --from=builder /build/target/${APP_NAME}.jar /app/${APP_NAME}.jar

WORKDIR /app

CMD java -jar ${APP_NAME}.jar

EXPOSE 8080
