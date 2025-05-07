package com.kafka.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final List<String> messages = new CopyOnWriteArrayList<>();

    String msg = "";

    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
        msg = message;
    }

    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Consumed !!!: " + record.value());
        messages.add(record.value());
    }

    public List<String> getMessages() {
        System.out.println("Hello: " + messages);
        return messages;
    }

    public String getMsg(){
        return msg;
    } 
}
