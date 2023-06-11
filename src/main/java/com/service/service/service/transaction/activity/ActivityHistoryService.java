
package com.service.service.service.transaction.activity;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.transaction.activity.ActivityHistoryEntity;
import com.service.service.repository.transaction.activity.ActivityHistoryRepository;

 
@Service
public class ActivityHistoryService extends CommonUtil { 
@Autowired
    ActivityHistoryRepository repository;

    public ActivityHistoryEntity save(ActivityHistoryEntity entity) {
        return repository.save(entity);
    }

    public ActivityHistoryEntity update(String id, ActivityHistoryEntity entity) {
        ActivityHistoryEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public ActivityHistoryEntity getById(String id) {
        // return repository.getById(id);
        Optional<ActivityHistoryEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<ActivityHistoryEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public Page<ActivityHistoryEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<ActivityHistoryEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<ActivityHistoryEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}