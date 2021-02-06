package com.octopus.functionalUnitManagement.service.interfaces;

import com.octopus.functionalUnitManagement.models.FunctionalUnit;

import java.util.List;
import java.util.Optional;


public interface IFunctionalUnitGatewayService {
    FunctionalUnit createUnit(FunctionalUnit functionalUnit);
    List<FunctionalUnit> getAllUnits(String unitName);
    Optional<FunctionalUnit> getUnitById(String id);
}
