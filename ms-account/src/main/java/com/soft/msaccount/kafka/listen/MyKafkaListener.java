package com.soft.msaccount.kafka.listen;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    @KafkaListener(groupId = "abcGroup",topics = "xyzTopic")
    // @KafkaListener(groupId = "abcGroup",topicPartitions = {@TopicPartition(partitions = {"0","1","2"},topic = "xyzTopic")})
    @SendTo("xyzReponseTopic")
    public String handleMessage(String message){
        System.out.println("*********** ----------- Message : " + message);
        return "Processed " + message;
    }

}
