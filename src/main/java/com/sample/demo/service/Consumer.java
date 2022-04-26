package com.sample.demo.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.sample.demo.model.EmployeeDetails;
import com.sample.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;

@Service
//@Component
//@KafkaListener(topics = "topic-two", groupId = "group")
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    @Autowired
    EmployeeRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Producer producer;

    @KafkaListener(topics="topic-two", groupId="group")
    @KafkaHandler(isDefault = true)
    public void consumeFromTopic(String employeeDetails) throws JsonProcessingException {
      System.out.println("Employee from Json :"+employeeDetails);
      EmployeeDetails obj = objectMapper.readValue(employeeDetails,EmployeeDetails.class);
      logger.info("Employee on-boarding data saved in DB");
      repository.save(obj);
      logger.info("Consumed message : "+employeeDetails);
    }
}
