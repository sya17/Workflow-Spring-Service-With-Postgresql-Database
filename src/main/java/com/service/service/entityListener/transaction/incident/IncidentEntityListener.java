
package com.service.service.entityListener.transaction.incident;

import java.util.Date;

import com.service.service.entity.transaction.incident.IncidentEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class IncidentEntityListener { 
 
@PrePersist
public void prePersist(IncidentEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(IncidentEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}