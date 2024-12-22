package com.example.service;



import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topicPartitions =
            {@TopicPartition(topic = "she", partitions = {"0"})
            })
    public void listen(String message) {
        log.info("-------------------------");
        log.info(message);
        System.out.println("Received message: " + message);

    }

    @KafkaListener(topicPartitions =
            {@TopicPartition(topic = "she", partitions = {"1"})
            })
    public void listenHistory(String message) {
        log.info("+++++++++++++++++++");
        log.info(message);
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topicPartitions =
            {@TopicPartition(topic = "she", partitions = {"2"})
            })
    public void listenHistor(String message) {
        log.info("============");
        log.info(message);
        System.out.println("Received message: " + message);
    }
}