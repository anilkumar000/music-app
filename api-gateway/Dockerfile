FROM openjdk:11

WORKDIR /user/src

ADD ./target/api-gateway-0.0.1-SNAPSHOT.jar /user/src/api-gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","api-gateway-0.0.1-SNAPSHOT.jar"]