FROM amazoncorretto:21-alpine

ARG USER=1001
RUN mkdir "app"
COPY --chmod=0755 build/libs/javaNotesApi-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
RUN chown -R $USER:$USER /app
USER $USER

ENTRYPOINT ["java", "-jar", "/app/javaNotesApi-0.0.1-SNAPSHOT.jar"]

