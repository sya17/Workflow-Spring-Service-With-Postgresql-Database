
package com.service.service.service.masterdata;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.GroupEntity;
import com.service.service.repository.masterdata.GroupRepository;

 
@Service
public class GroupService extends CommonUtil { 
@Autowired
    GroupRepository repository;

    public GroupEntity save(GroupEntity entity) {
        return repository.save(entity);
    }

    public GroupEntity update(String id, GroupEntity entity) {
        GroupEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public GroupEntity getById(String id) {
        // return repository.getById(id);
        Optional<GroupEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<GroupEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public List<GroupEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<GroupEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}