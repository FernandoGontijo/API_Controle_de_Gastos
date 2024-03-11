FROM maven:3.8.3-openjdk-17

WORKDIR /app
COPY . .

EXPOSE 8080

RUN mvn clean package

CMD mvn spring-boot:run