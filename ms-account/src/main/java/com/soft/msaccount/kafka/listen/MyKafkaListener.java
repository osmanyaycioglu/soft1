package com.soft.msaccount.kafka.listen;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    @KafkaListener(groupId = "abcGroup",topics = "xyzTopic")
    // @KafkaListener(groupId = "abcGroup",topicPartitions = {@TopicPartition(partitions = {"0","1","2"},topic = "xyzTopic")})
    @SendTo("xyzReponseTopic")
    // public String handleMessage(Message<String>  message)
    public String handleMessage(@Payload String message,
                                @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partId,
                                @Header(KafkaHeaders.OFFSET) Integer offset
                                ){
        System.out.println("*********** ----------- Message : " + message);
        return "Processed " + message;
    }

}
