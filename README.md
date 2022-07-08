# Kafka

installation:
--------------------------
https://kafka.apache.org/quickstart#quickstart_createtopic

https://kafka.apache.org/downloads
download Binary
extract to
C:\java\kafka

git bash
bin/zookeeper-server-start.sh config/zookeeper.properties

NEW (!!!) git bash
bin/kafka-server-start.sh config/server.properties
--------------------------





try from console:
--------------------------
NEW (!!!) git bash
bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092

NEW (!!!) git bash
bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

got to console-producer and print message
--------------------------




run:
--------------------------
C:\java\kafka

git bash
bin/zookeeper-server-start.sh config/zookeeper.properties

NEW (!!!) git bash
bin/kafka-server-start.sh config/server.properties

run consumer (in idea)
run producer (in idea)
--------------------------
