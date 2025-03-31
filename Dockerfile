FROM container-registry.oracle.com/graalvm/native-image:23-ol8 AS builder

WORKDIR /build

COPY . .

RUN ./mvnw --no-transfer-progress native:compile -Pnative

# The deployment Image
FROM gcr.io/distroless/java-base-debian12

EXPOSE 8080

COPY --from=builder /build/framework/target/framework /app

ENTRYPOINT ["/app"]