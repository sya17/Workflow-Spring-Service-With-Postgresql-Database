package com.service.service.service.masterdata.workflow;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.service.entity.masterdata.workflow.WorkflowGroupEntity;
import com.service.service.repository.masterdata.workflow.WorkflowGroupRepository;

@Service
public class WorkflowGroupService {
    
    @Autowired
    WorkflowGroupRepository repository;

    public WorkflowGroupEntity save(WorkflowGroupEntity entity) {
        return repository.save(entity);
    }

    public WorkflowGroupEntity update(String id, WorkflowGroupEntity entity) {
        Optional<WorkflowGroupEntity> user = getById(id);
        return (!user.isEmpty() ? repository.save(entity) : null);
    }

    public Optional<WorkflowGroupEntity> getById(String id) {
        return repository.findById(id);
    }

    public List<WorkflowGroupEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<WorkflowGroupEntity> user = getById(id);
        if(!user.isEmpty()){
            repository.deleteById(id);
        }
        return !user.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
