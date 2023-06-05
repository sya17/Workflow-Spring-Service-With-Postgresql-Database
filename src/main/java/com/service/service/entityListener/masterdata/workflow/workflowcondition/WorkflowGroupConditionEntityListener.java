package com.service.service.entityListener.masterdata.workflow.workflowcondition;

import java.util.Date;

import com.service.service.entity.masterdata.workflow.workflowcondition.WorkflowGroupConditionEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class WorkflowGroupConditionEntityListener {
    
    @PersistenceContext
    private EntityManager entityManager;

    @PrePersist
    public void prePersist(WorkflowGroupConditionEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(WorkflowGroupConditionEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}
