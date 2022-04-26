package com.sample.demo.service;

import com.sample.demo.model.EmployeeDetails;
import com.sample.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    public static final String topic = "topic-two";

    @Autowired
    private KafkaTemplate<String, EmployeeDetails> kafkaTemplate;

    public void publishToTopic(EmployeeDetails employeeDetails)
    {
     logger.info("Publishing to topic : "+topic);
     this.kafkaTemplate.send(topic,employeeDetails);
     //repository.save(employeeDetails);
     logger.info("Message is produced");
    }

}
