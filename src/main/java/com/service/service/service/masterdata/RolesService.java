
package com.service.service.service.masterdata;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.RolesEntity;
import com.service.service.repository.masterdata.RolesRepository;

 
@Service
public class RolesService extends CommonUtil { 
@Autowired
    RolesRepository repository;

    public RolesEntity save(RolesEntity entity) {
        return repository.save(entity);
    }

    public RolesEntity update(String id, RolesEntity entity) {
        RolesEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public RolesEntity getById(String id) {
        // return repository.getById(id);
        Optional<RolesEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<RolesEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public List<RolesEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<RolesEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}