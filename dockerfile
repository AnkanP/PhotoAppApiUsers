FROM openjdk:11
VOLUME /tmp
COPY target/PhotoappApiUsers-0.0.1-SNAPSHOT.jar ApiUsers.jar
ENTRYPOINT ["java", "-jar" ,"ApiUsers.jar"]