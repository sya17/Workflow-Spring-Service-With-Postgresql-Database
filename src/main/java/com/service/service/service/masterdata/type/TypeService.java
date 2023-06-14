
package com.service.service.service.masterdata.type;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.type.TypeEntity;
import com.service.service.repository.masterdata.type.TypeRepository;

 
@Service
public class TypeService extends CommonUtil { 
@Autowired
    TypeRepository repository;

    public TypeEntity save(TypeEntity entity) {
        return repository.save(entity);
    }

    public TypeEntity update(String id, TypeEntity entity) {
        TypeEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public TypeEntity getById(String id) {
        // return repository.getById(id);
        Optional<TypeEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<TypeEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public Page<TypeEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<TypeEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<TypeEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}