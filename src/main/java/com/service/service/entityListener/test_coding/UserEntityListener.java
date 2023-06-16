
package com.service.service.entityListener.test_coding;

import java.util.Date;

import com.service.service.entity.test_coding.UserEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class UserEntityListener { 
 
@PrePersist
public void prePersist(UserEntity entity) {
        Date now = new Date();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

@PreUpdate
public void preUpdate(UserEntity entity) {
        entity.setUpdatedAt(new Date());
    }
}