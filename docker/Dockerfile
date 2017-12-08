FROM openjdk:8u121-alpine
ADD hangman-api-0.0.1-SNAPSHOT.jar app.jar
RUN touch /app.jar

ENTRYPOINT ["sh", "-l", "-c","java -Djava.security.egd=file:/dev/./urandom -Dserver.port=8080 -jar /app.jar"]