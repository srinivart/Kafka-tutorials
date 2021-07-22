package com.srinivart.employee;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;


@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

        MessageProducer producer = context.getBean(MessageProducer.class);
        MessageListener listener = context.getBean(MessageListener.class);

        producer.sendEmployeeMessage(new Employee("sree", "hello!"));
        listener.employeeLatch.await(10, TimeUnit.SECONDS);

        context.close();



    }

    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }

    @Bean
    public MessageListener messageListener() {
        return new MessageListener();
    }

    public static class MessageProducer {

        @Autowired
        private KafkaTemplate<String, String> kafkaTemplate;

        @Autowired
        private KafkaTemplate<String, Employee> employeeKafkaTemplate;

        @Value(value = "${message.topic.name}")
        private String topicName;

        @Value(value = "${employee.topic.name}")
        private String employeeTopicName;

        public void sendEmployeeMessage(Employee employee) {
            employeeKafkaTemplate.send(employeeTopicName, employee);
        }
    }


    public static class MessageListener {

        private CountDownLatch latch = new CountDownLatch(3);

        private CountDownLatch employeeLatch = new CountDownLatch(1);



//        @KafkaListener(topics = "${message.topic.name}", groupId = "test-consumer-group", containerFactory = "employeeKafkaListenerContainerFactory")
//        public void listenGroupTest(Employee message) {
//            System.out.println("Received Message in group 'test': " + message);
//            latch.countDown();
//        }

        @KafkaListener(topics = "${employee.topic.name}", containerFactory = "employeeKafkaListenerContainerFactory")
        public void employeeListener(Employee employee) {
            System.out.println("Received employee message: " + employee.toString());
            this.employeeLatch.countDown();
        }


    }

}


