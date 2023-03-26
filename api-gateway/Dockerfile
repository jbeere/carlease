FROM openjdk:11
WORKDIR /build
ADD ./target/api-gateway-0.0.1-SNAPSHOT.jar ./api-gateway.jar
EXPOSE 8080
CMD java -jar api-gateway.jar