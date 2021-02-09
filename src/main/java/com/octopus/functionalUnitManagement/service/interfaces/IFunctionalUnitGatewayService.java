package com.octopus.functionalUnitManagement.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;

import java.util.List;
import java.util.Optional;


public interface IFunctionalUnitGatewayService {
    FunctionalUnit createUnit(FunctionalUnit functionalUnit);
    List<FunctionalUnit> getAllUnits(String unitName, String subType);
    Optional<FunctionalUnit> getUnitById(String id);

    void updateUnit(String id, JsonMergePatch payload) throws JsonPatchException;
}
