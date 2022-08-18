package com.muratkistan.springbootkafkadocker.kafka;

import com.muratkistan.springbootkafkadocker.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "muratkistan_json",groupId = "group-1")
    public void consume(User user){
        log.info("Message received as json format : "+ user.toString() );
    }

}
