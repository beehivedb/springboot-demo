#using java 8 run microservice.
FROM java:8
MAINTAINER Ron
ADD springboot-demo-0.0.1-SNAPSHOT.jar /usr/local/
EXPOSE 8080
WORKDIR /usr/local/
CMD ["java", "-jar", "springboot-demo-0.0.1-SNAPSHOT.jar"]
