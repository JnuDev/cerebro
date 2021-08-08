FROM openjdk:8-jdk-slim
COPY "./target/cerebro-0.0.1-SNAPSHOT.jar" "cerebro.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","cerebro.jar"]