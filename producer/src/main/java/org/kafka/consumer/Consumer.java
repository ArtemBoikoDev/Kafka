package org.kafka.consumer;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Kafka consumer application.
 *
 * @author Artem Boiko
 */
@SpringBootApplication
public class Consumer {
    private static final Logger logger = LogManager.getLogger(Consumer.class);

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
                           .partitions(10)
                           .replicas(1)
                           .build();
    }

    @KafkaListener(id = "myId", topics = "topic1")
    public void listen(String inputMessage) {
        logger.info(inputMessage);
    }
}
