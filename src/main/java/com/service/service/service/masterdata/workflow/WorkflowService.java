
package com.service.service.service.masterdata.workflow;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.workflow.WorkflowEntity;
import com.service.service.repository.masterdata.workflow.WorkflowRepository;

 
@Service
public class WorkflowService extends CommonUtil { 
@Autowired
    WorkflowRepository repository;

    public WorkflowEntity save(WorkflowEntity entity) {
        return repository.save(entity);
    }

    public WorkflowEntity update(String id, WorkflowEntity entity) {
        WorkflowEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public WorkflowEntity getById(String id) {
        // return repository.getById(id);
        Optional<WorkflowEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<WorkflowEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public Page<WorkflowEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<WorkflowEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<WorkflowEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}