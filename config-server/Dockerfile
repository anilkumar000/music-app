FROM openjdk:11

WORKDIR /user/src

ADD ./target/config-server-0.0.1-SNAPSHOT.jar /user/src/config-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","config-server-0.0.1-SNAPSHOT.jar"]