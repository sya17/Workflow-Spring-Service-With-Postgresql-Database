
package com.service.service.entityListener.masterdata.workflow.workflowcondition;

import java.util.Date;

import com.service.service.entity.masterdata.workflow.workflowcondition.WorkflowConditionEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class WorkflowConditionEntityListener { 
 
@PrePersist
public void prePersist(WorkflowConditionEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(WorkflowConditionEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}