package com.sample.demo.controller;

import com.sample.demo.model.EmployeeDetails;
import com.sample.demo.service.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/kafka")
public class KafkaController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    @Autowired
    Producer producer;

    @PostMapping(value = "/add/emp/details")
    public ResponseEntity<String> addEmpData(@RequestBody EmployeeDetails employeeDetails)
    {
     logger.info("Inside addEmpData method of kafka controller class ");
     producer.publishToTopic(employeeDetails);
     logger.info("Returning addEmpData response ");
     return new ResponseEntity<>("Employee On-boarding details added Successfully...", HttpStatus.OK);
    }
    @GetMapping("/find/emp/details")
    public ResponseEntity<List<EmployeeDetails>> findAllEmployees(){
        logger.info("Inside findAllEmployees method of kafka controller class ");
        logger.info("Returning findAllEmployees response ");
        return new ResponseEntity<>(producer.findAllEmployees(), HttpStatus.OK);
    }

}
