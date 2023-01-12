# Use JDK amazon corretto 17
FROM amazoncorretto:17

#COPY JAR FILE
COPY target/revagenda*.jar revagenda.jar

ENTRYPOINT ["java","-jar","/revagenda.jar"]