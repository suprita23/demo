FROM openjdk:11.0.8-jre
VOLUME /tmp
ADD target/demo2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080/tcp
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
