package com.service.service.entityListener.masterdata.workflow;

import java.util.Date;
import com.service.service.entity.masterdata.workflow.WorkflowGroupEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class WorkflowGroupEntityListener {
    
    @PersistenceContext
    private EntityManager entityManager;

    @PrePersist
    public void prePersist(WorkflowGroupEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(WorkflowGroupEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}
