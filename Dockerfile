FROM amazoncorretto:17-alpine3.15
LABEL MANTAINER="CISP"
WORKDIR /app
EXPOSE 8080
RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'
ENV JAVA_OPTS="-Xms128m -Xmx384m"
ARG JAR_FILE=framework/target/*.jar
COPY framework/target/*.jar app.jar
ENTRYPOINT java $JAVA_OPTS -javaagent:dd-java-agent.jar -jar app.jar
