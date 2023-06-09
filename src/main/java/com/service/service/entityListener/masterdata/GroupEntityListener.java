
package com.service.service.entityListener.masterdata;

import java.util.Date;

import com.service.service.entity.masterdata.GroupEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class GroupEntityListener { 
 
@PrePersist
public void prePersist(GroupEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(GroupEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}