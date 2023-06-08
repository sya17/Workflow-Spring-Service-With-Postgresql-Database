
package com.service.service.entityListener.masterdata;
import java.util.Date;

import com.service.service.entity.masterdata.RolesEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
public class RolesEntityListener { 
 
@PrePersist
    public void prePersist(RolesEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(RolesEntity entity) {
        entity.setUpdatedAt(new Date());
    }}