
package com.service.service.service.masterdata.workflow.workflowcondition;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.workflow.workflowcondition.WorkflowConditionEntity;
import com.service.service.repository.masterdata.workflow.workflowcondition.WorkflowConditionRepository;

 
@Service
public class WorkflowConditionService extends CommonUtil { 
@Autowired
    WorkflowConditionRepository repository;

    public WorkflowConditionEntity save(WorkflowConditionEntity entity) {
        return repository.save(entity);
    }

    public WorkflowConditionEntity update(String id, WorkflowConditionEntity entity) {
        WorkflowConditionEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public WorkflowConditionEntity getById(String id) {
        // return repository.getById(id);
        Optional<WorkflowConditionEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<WorkflowConditionEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public List<WorkflowConditionEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<WorkflowConditionEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}