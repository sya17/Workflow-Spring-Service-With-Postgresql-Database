
package com.service.service.entityListener.masterdata.type;

import java.util.Date;

import com.service.service.entity.masterdata.type.CityEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class CityEntityListener { 
 
@PrePersist
public void prePersist(CityEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(CityEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}