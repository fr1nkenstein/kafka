package com.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.logging.LogLevel;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaAdmin admin;

    public void sendMessage(String topic, String message, Integer partition) {
        ProducerRecord<String, String> p = new ProducerRecord<>(topic, 0, "DASHBOARD", "this is on dashboard3");
        ProducerRecord<String, String> q = new ProducerRecord<>(topic, 1, "HISTORY", "this is on history");
        ProducerRecord<String, String> r = new ProducerRecord<>(topic, 2, "FUN", "this is on fun");
        kafkaTemplate.send(p);
        kafkaTemplate.send(q);
        kafkaTemplate.send(r);
//        log.info("heyy this where the flow came to me " );
    }

    public void createTopic(String topic) {
        AdminClient client = AdminClient.create(admin.getConfigurationProperties());
        NewTopic topic1 = new NewTopic(topic, 2, (short) 1);
        List<NewTopic> topicList = new ArrayList<>();
        topicList.add(topic1);
        log.info(client.createTopics(topicList).toString() + "----------");
        client.close();
    }

    public void updateTopic(String topic, Integer partition, List<List<Integer>> partitions) {
        AdminClient client = AdminClient.create(admin.getConfigurationProperties());
        Map<String, NewPartitions> s = new HashMap<>();
        ListTopicsResult t = client.listTopics();
        List<List<Integer>> a = new ArrayList<>();
        s.put(topic, NewPartitions.increaseTo(partition, partitions));
        CreatePartitionsResult cr = client.createPartitions(s);
        client.close();
    }
}
