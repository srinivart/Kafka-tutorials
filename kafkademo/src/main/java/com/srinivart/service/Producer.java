package com.srinivart.service;

import com.srinivart.model.Employee;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Value("${kafka.topic.name:employees}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void publishToTopic(String employee){
        log.info("publishing to topic "+topic);
        log.info("Employee object : "+employee);
        this.kafkaTemplate.send(topic, employee);
        //ProducerRecord prodRecord = new ProducerRecord(topic, employee);
        // this.kafkaTemplate.send(topic, employee);
    }

}
