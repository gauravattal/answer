FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/answer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
CMD ["java", "-jar", "app.jar"]