FROM openjdk:11
WORKDIR /build
ADD ./target/discovery-server-0.0.1.jar ./discovery-server.jar
EXPOSE 8761
CMD java -jar discovery-server.jar