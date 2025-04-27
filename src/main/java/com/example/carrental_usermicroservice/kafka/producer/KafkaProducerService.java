package com.example.carrental_usermicroservice.kafka.producer;

import com.example.carrental_usermicroservice.dto.ValidUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreatedMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Sent message: " + message);
    }
}
