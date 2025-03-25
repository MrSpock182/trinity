FROM amazoncorretto:17-alpine3.15
LABEL MANTAINER="CISP"

WORKDIR /app
EXPOSE 8080

ARG JAR_FILE=framework/target/*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]