
package com.service.service.entityListener.masterdata.workflow;

import java.util.Date;

import com.service.service.entity.masterdata.workflow.WorkflowEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class WorkflowEntityListener { 
 
@PrePersist
public void prePersist(WorkflowEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(WorkflowEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}