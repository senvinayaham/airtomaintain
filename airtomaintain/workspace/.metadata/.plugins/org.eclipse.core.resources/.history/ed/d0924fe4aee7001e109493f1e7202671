#Start with a base image containing java runtime
FROM openjdk:17-jdk-slim

#Information around who maintain the application
MAINTAINER AirToMaintain

#Copy the application jar to image
COPY target/maintenance-0.0.1-SNAPSHOT.jar maintenance-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar", "maintenance-0.0.1-SNAPSHOT.jar"]