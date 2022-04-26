package com.sample.demo.repository;

import com.sample.demo.model.EmployeeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeDetails,Integer> {
}
