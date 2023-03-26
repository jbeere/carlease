FROM openjdk:11
WORKDIR /build
ADD ./target/customer-api-0.0.1-SNAPSHOT.jar ./customer-api.jar
EXPOSE 8080
CMD java -jar customer-api.jar