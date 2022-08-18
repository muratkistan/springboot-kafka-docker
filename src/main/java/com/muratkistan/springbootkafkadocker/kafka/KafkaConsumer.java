package com.muratkistan.springbootkafkadocker.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "muratkistan",groupId="myGroup")
    public void consume(String message){
        log.info("Message Received from Kafka Queue : " + message);
    }
}
