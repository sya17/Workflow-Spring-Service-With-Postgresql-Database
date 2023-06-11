package com.service.service.service.masterdata.workflow;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.workflow.WorkflowGroupEntity;
import com.service.service.repository.masterdata.workflow.WorkflowGroupRepository;

@Service
public class WorkflowGroupService extends CommonUtil {

    @Autowired
    WorkflowGroupRepository repository;

    public WorkflowGroupEntity save(WorkflowGroupEntity entity) {
        return repository.save(entity);
    }

    public WorkflowGroupEntity update(String id, WorkflowGroupEntity entity) {
        WorkflowGroupEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public WorkflowGroupEntity getById(String id) {
        // return repository.getById(id);
        Optional<WorkflowGroupEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<WorkflowGroupEntity> getByIdOpt(String id) {
        return repository.findById(id);
    }

    public Page<WorkflowGroupEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<WorkflowGroupEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<WorkflowGroupEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
