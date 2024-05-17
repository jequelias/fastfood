FROM openjdk:22-jdk-slim

COPY . /app

WORKDIR /app

RUN ["./mvnw", "clean", "install", "-DskipTests"]

ENTRYPOINT ["./mvnw", "spring-boot:run"]