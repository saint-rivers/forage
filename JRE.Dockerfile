FROM eclipse-temurin:17.0.3_7-jre-alpine
COPY build/libs/f-server-0.0.1-SNAPSHOT.jar /opt/root.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/root.jar"]