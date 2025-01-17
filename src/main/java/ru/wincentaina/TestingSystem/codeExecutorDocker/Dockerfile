FROM --platform=linux/amd64 eclipse-temurin:17-jdk
#RUN addgroup -S appgroup && adduser -S appuser -G appgroup
WORKDIR /app
COPY . .
COPY start.sh /app/start.sh
RUN chmod +x start.sh
COPY jackson-core-2.18.2.jar /app/libs/
COPY jackson-databind-2.18.2.jar /app/libs/
COPY jackson-annotations-2.18.2.jar /app/libs/
#USER appuser
CMD ["/bin/sh", "start.sh"]