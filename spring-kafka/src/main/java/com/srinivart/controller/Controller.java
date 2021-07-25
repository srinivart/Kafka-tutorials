package com.srinivart.controller;

import com.srinivart.employee.Employee1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping(path = "/send/emp/{val}")
    public void SendEmp(@PathVariable String val) {
        this.template.send("topic1", new Employee1(val));
    }


    @PostMapping(path = "/send/emp")
    public void SendEmployee(@RequestBody Employee1 employee) {
        this.template.send("topic1", employee);
    }

}
