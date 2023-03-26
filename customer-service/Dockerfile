FROM openjdk:11
WORKDIR /build
ADD ./target/customer-service-0.0.1-SNAPSHOT.jar ./customer-service.jar
EXPOSE 8080
CMD java -jar customer-service.jar