package com.octopus.functionalUnitManagement.service.implementations;

import com.octopus.functionalUnitManagement.businessLogic.interfaces.IUtilityLogic;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.repository.interfaces.FunctionalUnitRepository;
import com.octopus.functionalUnitManagement.repository.interfaces.ICustomQueryBuilder;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FunctionalUnitGatewayService implements IFunctionalUnitGatewayService {

    @Autowired
    private IUtilityLogic utilityLogic;

    @Autowired
    private FunctionalUnitRepository functionalUnitRepository;

    @Autowired
    private ICustomQueryBuilder customQueryBuilder;

    @Override
    public FunctionalUnit createUnit(FunctionalUnit functionalUnit) {
        functionalUnit.setId("Workgroup_"+ utilityLogic.IdGenerator());
        functionalUnitRepository.save(functionalUnit);
        return functionalUnit;
    }

    @Override
    public List<FunctionalUnit> getAllUnits(String unitName) {
        if (unitName == null)
            return functionalUnitRepository.findAll();
        return customQueryBuilder.getWorkUnits(unitName);
    }

    @Override
    public Optional<FunctionalUnit> getUnitById(String id) {
        return functionalUnitRepository.findById(id);
    }
}
