FROM openjdk:17

COPY ./build/libs/demo-0.0.1-SNAPSHOT.jar /usr/local/bin/app.jar
RUN chmod +x /usr/local/bin/app.jar

CMD ["java", "-jar", "/usr/local/bin/app.jar"]