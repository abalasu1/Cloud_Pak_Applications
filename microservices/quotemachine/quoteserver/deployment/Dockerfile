FROM 3.6.3-ibmjava-8 AS MAVEN_BUILD

COPY ../pom.xml /build/
COPY ../src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/quoteserver-1.0.0.jar /app/

EXPOSE 8002
ENTRYPOINT ["java", "-jar", "quoteserver-1.0.0.jar"]
