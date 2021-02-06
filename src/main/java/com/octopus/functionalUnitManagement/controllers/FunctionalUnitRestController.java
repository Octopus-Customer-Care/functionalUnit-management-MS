package com.octopus.functionalUnitManagement.controllers;

import com.octopus.functionalUnitManagement.models.Employee;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workUnitManagement/v1")
public class FunctionalUnitRestController {

    @Autowired
    private IFunctionalUnitGatewayService functionalUnitGatewayService;

    @GetMapping(value = "/workUnit")
    List<FunctionalUnit> getAllWorkUnits(@RequestParam(name = "name", required = false) String unitName) {
        return functionalUnitGatewayService.getAllUnits(unitName);
    }

    @GetMapping(value = "/workUnit/{id}")
    public Optional<FunctionalUnit> getUnitById(@PathVariable("id") String id) {
        return functionalUnitGatewayService.getUnitById(id);
    }

    @PostMapping(value = "workUnit")
    public FunctionalUnit createWorkUnit(@RequestBody FunctionalUnit functionalUnit) {
        return functionalUnitGatewayService.createUnit(functionalUnit);
    }

}
