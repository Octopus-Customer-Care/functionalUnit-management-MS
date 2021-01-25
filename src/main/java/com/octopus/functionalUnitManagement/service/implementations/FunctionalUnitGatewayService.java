package com.octopus.functionalUnitManagement.service.implementations;

import com.octopus.functionalUnitManagement.businessLogic.interfaces.IUtilityLogic;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.repository.FunctionalUnitRepository;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FunctionalUnitGatewayService implements IFunctionalUnitGatewayService {

    @Autowired
    private IUtilityLogic utilityLogic;

    @Autowired
    private FunctionalUnitRepository functionalUnitRepository;

    @Override
    public FunctionalUnit createUnit(FunctionalUnit functionalUnit) {
        functionalUnit.setId("Workgroup_"+ utilityLogic.IdGenerator());
        functionalUnitRepository.save(functionalUnit);
        return functionalUnit;
    }

    @Override
    public List<FunctionalUnit> getAllUnits() {
        return functionalUnitRepository.findAll();
    }

    @Override
    public Optional<FunctionalUnit> getUnitById(String id) {
        return functionalUnitRepository.findById(id);
    }
}
