
package com.service.service.entityListener.masterdata.location;

import java.util.Date;

import com.service.service.entity.masterdata.location.LocationEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class LocationEntityListener { 
 
@PrePersist
public void prePersist(LocationEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(LocationEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}