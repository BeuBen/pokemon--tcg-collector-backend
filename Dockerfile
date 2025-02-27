FROM openjdk:23-jdk

EXPOSE 8080

COPY target/pokemon--tcg-collector-*.jar pokemon--tcg-collector.jar

ENTRYPOINT ["java","-jar","pokemon--tcg-collector.jar"]