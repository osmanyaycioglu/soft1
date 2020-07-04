package com.soft.msaccount.kafka.listen;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    @KafkaListener(groupId = "abcGroup",topics = "xyzTopic")
    public void handleMessage(String message){
        System.out.println("*********** ----------- Message : " + message);
    }

}
