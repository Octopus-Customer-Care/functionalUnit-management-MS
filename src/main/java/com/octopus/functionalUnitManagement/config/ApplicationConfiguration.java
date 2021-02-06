package com.octopus.functionalUnitManagement.config;

import com.octopus.functionalUnitManagement.businessLogic.implementations.UtilityLogic;
import com.octopus.functionalUnitManagement.businessLogic.interfaces.IUtilityLogic;
import com.octopus.functionalUnitManagement.repository.implementations.CustomQueryBuilder;
import com.octopus.functionalUnitManagement.repository.interfaces.ICustomQueryBuilder;
import com.octopus.functionalUnitManagement.service.implementations.EmployeeGatewayService;
import com.octopus.functionalUnitManagement.service.implementations.FunctionalUnitGatewayService;
import com.octopus.functionalUnitManagement.service.interfaces.IEmployeeGatewayService;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public IUtilityLogic utilityLogic() {
        return new UtilityLogic();
    }

    @Bean
    public IFunctionalUnitGatewayService functionalUnitGatewayService() {
        return new FunctionalUnitGatewayService();
    }

    @Bean
    public IEmployeeGatewayService employeeGatewayService() {
        return new EmployeeGatewayService();
    }
}
