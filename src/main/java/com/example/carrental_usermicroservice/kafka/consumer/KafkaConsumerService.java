package com.example.carrental_usermicroservice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    /*@KafkaListener(topics = "test-topic", groupId = "my-group")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }*/
}
