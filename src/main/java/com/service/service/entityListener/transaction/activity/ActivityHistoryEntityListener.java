
package com.service.service.entityListener.transaction.activity;

import java.util.Date;

import com.service.service.entity.transaction.activity.ActivityHistoryEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class ActivityHistoryEntityListener { 
 
@PrePersist
public void prePersist(ActivityHistoryEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(ActivityHistoryEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}