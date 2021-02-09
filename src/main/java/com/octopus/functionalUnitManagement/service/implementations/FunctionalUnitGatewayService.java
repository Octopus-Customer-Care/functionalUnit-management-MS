package com.octopus.functionalUnitManagement.service.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.octopus.functionalUnitManagement.businessLogic.interfaces.IUtilityLogic;
import com.octopus.functionalUnitManagement.models.FunctionalUnit;
import com.octopus.functionalUnitManagement.repository.interfaces.FunctionalUnitRepository;
import com.octopus.functionalUnitManagement.repository.interfaces.ICustomQueryBuilder;
import com.octopus.functionalUnitManagement.service.interfaces.IFunctionalUnitGatewayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FunctionalUnitGatewayService implements IFunctionalUnitGatewayService {

    private ObjectMapper objectMapper = new ObjectMapper();

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
    public List<FunctionalUnit> getAllUnits(String unitName, String subType) {
        if (unitName == null && subType == null)
            return functionalUnitRepository.findAll();
        String workUnitName = "", caseSubType = "";
        if (unitName != null)
            workUnitName = unitName;
        if (subType != null)
            caseSubType = subType;
        return customQueryBuilder.getWorkUnits(workUnitName, caseSubType);
    }

    @Override
    public Optional<FunctionalUnit> getUnitById(String id) {
        return functionalUnitRepository.findById(id);
    }

    @Override
    public void updateUnit(String id, JsonMergePatch payload) throws JsonPatchException{
        Optional<FunctionalUnit> functionalUnit = functionalUnitRepository.findById(id);
        FunctionalUnit patchedUnit = applyPatchToCustomer(payload, functionalUnit);
        functionalUnitRepository.save(patchedUnit);
    }

    private FunctionalUnit applyPatchToCustomer(JsonMergePatch patch, Optional<FunctionalUnit> targetCustomer) throws JsonPatchException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
        try {
            return objectMapper.treeToValue(patched, FunctionalUnit.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
