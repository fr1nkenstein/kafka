package com.example.controller;

import com.example.service.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaProducer kafkaProducer;


    @PostMapping("/publish")
    public String publishMessage(@RequestParam String topic, @RequestParam String message, @RequestParam Integer partition) {
       kafkaProducer.sendMessage(topic, message, partition);
        Thread.startVirtualThread(()->{
            for(int i=0;i<11000000;i++) System.out.println(i++);
        });
        Thread.startVirtualThread(()->{
            for(int i=0;i<11000000;i++) System.out.println(i++);
        });
        return "Message sent to topic: " + topic;
    }

    @PostMapping("/update")
    public String publishMessage(@RequestParam String topic, @RequestParam Integer partition, @RequestBody List<List<Integer>> partitions) {
        kafkaProducer.updateTopic(topic, partition, partitions);
        return "Message sent to topic: " + topic;
    }

    @PostMapping("/create")
    public String publishMessage(@RequestParam String topic) {
        kafkaProducer.createTopic(topic);
        return "Message sent to topic: " + topic;
    }
}
