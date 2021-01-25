package com.octopus.functionalUnitManagement.repository;

import com.octopus.functionalUnitManagement.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
