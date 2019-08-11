FROM openjdk:11

WORKDIR /user/src

ADD ./target/userservice-0.0.1-SNAPSHOT.jar /user/src/userservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]