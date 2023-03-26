FROM openjdk:11
WORKDIR /build
ADD ./target/lease-service-0.0.1-SNAPSHOT.jar ./lease-service.jar
EXPOSE 8080
CMD java -jar lease-service.jar