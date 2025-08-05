# Kafka Message Streamer 

A Java-based Kafka application for streaming messages using CLI tools and Kafka topics.

## Features
- Java producer and consumer
- Kafka topic creation and message streaming
- CLI interaction via Git Bash
- Real-time offset tracking

## Screenshots

### Producer CLI
![Producer CLI](assets/Producer%20CLI.png)

### Consumer CLI
![Consumer CLI](assets/Consumer_CLI.png.png)

## How to Run

```bash
# Start Zookeeper and Kafka
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties

# Create topic
bin/kafka-topics.sh --create --topic user-activity --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

# Run producer
java -jar kafka-producer.jar

# Run consumer
java -jar kafka-consumer.jar
