FROM openjdk:11

WORKDIR /user/src

ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar /user/src/eureka-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","eureka-server-0.0.1-SNAPSHOT.jar"]