package com.soft.order.kafka.listen;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    @KafkaListener(groupId = "abcResponseGroup",topics = "xyzReponseTopic")
    public void handleResponseMessage(String message){
        System.out.println("*********** ----------- Response Message : " + message);
    }

}
