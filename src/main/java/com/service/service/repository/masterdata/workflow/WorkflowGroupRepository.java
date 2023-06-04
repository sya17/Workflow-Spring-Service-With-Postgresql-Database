package com.service.service.repository.masterdata.workflow;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.service.entity.masterdata.workflow.WorkflowGroupEntity;


public interface WorkflowGroupRepository extends JpaRepository<WorkflowGroupEntity, String> {
    
}
