package com.service.service.service.masterdata.workflow.workflowcondition;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.workflow.workflowcondition.WorkflowGroupConditionEntity;
import com.service.service.repository.masterdata.workflow.workflowcondition.WorkflowGroupConditionRepository;

@Service
public class WorkflowGroupConditionService extends CommonUtil {

    @Autowired
    WorkflowGroupConditionRepository repository;

    public WorkflowGroupConditionEntity save(WorkflowGroupConditionEntity entity) {
        return repository.save(entity);
    }

    public WorkflowGroupConditionEntity update(String id, WorkflowGroupConditionEntity entity) {
        WorkflowGroupConditionEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public WorkflowGroupConditionEntity getById(String id) {
        // return repository.getById(id);
        Optional<WorkflowGroupConditionEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<WorkflowGroupConditionEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public List<WorkflowGroupConditionEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<WorkflowGroupConditionEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}
