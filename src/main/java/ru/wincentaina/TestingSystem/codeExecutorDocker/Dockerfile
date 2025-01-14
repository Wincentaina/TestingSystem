FROM --platform=linux/amd64 eclipse-temurin:17-jre-alpine
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
WORKDIR /app
RUN chmod 700 /app
USER appuser
CMD tail -f /dev/null