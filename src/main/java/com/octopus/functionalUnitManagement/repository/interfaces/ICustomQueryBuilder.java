package com.octopus.functionalUnitManagement.repository.interfaces;

import com.octopus.functionalUnitManagement.models.Employee;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;

import java.util.List;

public interface ICustomQueryBuilder {
    List<Employee> getEmployeeByName(String name);
    List<FunctionalUnit> getWorkUnits(String workUnit);
}
