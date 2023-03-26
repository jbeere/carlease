FROM openjdk:11
WORKDIR /build
ADD ./target/car-service-server-0.0.1-SNAPSHOT.jar ./car-service-server.jar
EXPOSE 8080
CMD java -jar car-service-server.jar