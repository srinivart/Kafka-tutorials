package com.srinivart.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.srinivart.model.Employee;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private Gson gson;




    @KafkaListener(topics = "#{'${kafka.topic.name:employees}'}", groupId = "test-consumer-group")
    public void consumerFromTopic(String employee) throws JsonProcessingException {
        log.info("Consumed msg "+employee);
        //log.info("name: "+ employee.getName());

        //JSONParser parser = new JSONParser();
       // JSONObject json = (JSONObject) parser.parse(employee);


        //Employee model = gson.fromJson(employee, Employee.class);
        //System.out.println("Model converted to String: " + model.toString());

        //Employee employee1 = new ObjectMapper().readValue(employee, Employee.class);
        //System.out.println("name -> "+employee1.getName());

    }


//    @KafkaListener(topics = { "employees" })
//    public void read(String employee){
//        System.out.println("Kafka event consumed is: " + employee);
//        Employee model = gson.fromJson(employee, Employee.class);
//        System.out.println("Model converted to String: " + model.toString());
//    }



}


