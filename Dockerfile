#build: docker build -f Dockerfiles/Dockerfile.native -t native-spring-boot-native:latest .

# Using Oracle GraalVM for JDK 23, OL8
FROM container-registry.oracle.com/graalvm/native-image:23-ol8 AS builder

# Set the working directory to /home/app
WORKDIR /build

# Copy the source code into the image for building
COPY . /build

# Build
RUN ./mvnw --no-transfer-progress native:compile -Pnative

# The deployment Image
FROM gcr.io/distroless/java-base-debian12

EXPOSE 8080

# Copy the native executable into the containers
COPY --from=builder /build/framework/target/framework /app
ENTRYPOINT ["/app"]