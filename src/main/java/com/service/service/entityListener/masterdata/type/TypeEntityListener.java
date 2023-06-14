
package com.service.service.entityListener.masterdata.type;

import java.util.Date;

import com.service.service.entity.masterdata.type.TypeEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TypeEntityListener { 
 
@PrePersist
public void prePersist(TypeEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(TypeEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}