FROM openjdk:11

WORKDIR /user/src

ADD ./target/userservice-0.0.1-SNAPSHOT.war /user/src/userservice-0.0.1-SNAPSHOT.war

ENTRYPOINT ["java","-war","userservice-0.0.1-SNAPSHOT.war"]