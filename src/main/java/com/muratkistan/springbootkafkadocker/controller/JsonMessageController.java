package com.muratkistan.springbootkafkadocker.controller;

import com.muratkistan.springbootkafkadocker.kafka.JsonKafkaProducer;
import com.muratkistan.springbootkafkadocker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/json")
public class JsonMessageController {
    private JsonKafkaProducer kafkaProducer;

    @Autowired
    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to queue : "+ user);
    }
}
