package com.example.patientService.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher {
    private final KafkaTemplate<String, Object> kafka;
    public KafkaPublisher(KafkaTemplate<String, Object> kafka) { this.kafka = kafka; }
    public void publish(String topic, String key, Object value) { kafka.send(topic, key, value); }
}