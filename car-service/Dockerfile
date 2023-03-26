FROM openjdk:11
WORKDIR /build
ADD ./target/car-service-0.0.1-SNAPSHOT.jar ./car-service.jar
EXPOSE 8080
CMD java -jar car-service.jar