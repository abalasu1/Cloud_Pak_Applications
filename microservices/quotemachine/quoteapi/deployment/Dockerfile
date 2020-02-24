FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY ../pom.xml /build/
COPY ../src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/quoteapi-1.0.0 /app/
ENTRYPOINT ["java", "-jar", "quoteapi-1.0.0.jar"]