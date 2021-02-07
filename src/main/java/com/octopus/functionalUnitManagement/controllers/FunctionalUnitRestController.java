package com.octopus.functionalUnitManagement.controllers;

import com.octopus.functionalUnitManagement.models.Employee;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class FunctionalUnitRestController {

    @Autowired
    private IFunctionalUnitGatewayService functionalUnitGatewayService;

    /**
     * @param unitName -
     *
     **/
    @GetMapping(value = "/workUnit")
    List<FunctionalUnit> getAllWorkUnits(@RequestParam(name = "unitName", required = false) String unitName,
                                         @RequestParam(name = "subType", required = false) String subType) {
        return functionalUnitGatewayService.getAllUnits(unitName, subType);
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
