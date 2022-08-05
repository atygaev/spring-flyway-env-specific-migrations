FROM openjdk:11

WORKDIR /app

COPY . .

RUN ./gradlew clean bootJar

RUN cp build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]