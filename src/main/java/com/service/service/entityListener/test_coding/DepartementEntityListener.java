
package com.service.service.entityListener.test_coding;

import java.util.Date;

import com.service.service.entity.test_coding.DepartementEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class DepartementEntityListener { 
 
@PrePersist
public void prePersist(DepartementEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(DepartementEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}