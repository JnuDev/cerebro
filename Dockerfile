FROM openjdk:8-jdk-slim
COPY "./target/cerebro-0.0.1-SNAPSHOT.jar" "cerebro.jar"
EXPOSE 8080

CMD ["sh", "-c", "java -jar -Dspring.data.mongodb.uri= cerebro.jar"]