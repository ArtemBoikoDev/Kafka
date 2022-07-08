package org.kafka.producer;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Kafka producer application.
 *
 * @author Artem Boiko
 */
@SpringBootApplication
public class Producer {
    public static void main(String[] args) {
        SpringApplication.run(Producer.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
                           .partitions(10)
                           .replicas(1)
                           .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> template.send("topic1",
                                     "My message on " +
                                     new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
