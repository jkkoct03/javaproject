package com.controllers;

import org.springframework.web.bind.annotation.*;

import com.kafka.services.KafkaConsumerService;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaMessageController {

    private final KafkaConsumerService consumerService;

    public KafkaMessageController(KafkaConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/messages")
    public List<String> getConsumedMessages() {
        return consumerService.getMessages();
    }

    @GetMapping("/fromTopic")
    public String getConsumedMessagesFromTopic() {
        return consumerService.getMsg();
    }
}

