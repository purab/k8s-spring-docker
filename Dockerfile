FROM adoptopenjdk:8-jre-hotspot

EXPOSE 8080

ADD target/docker-spring.jar docker-spring.jar

ENTRYPOINT ["java","-jar","docker-spring.jar"]
