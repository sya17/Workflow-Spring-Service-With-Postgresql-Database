
package com.service.service.service.test_coding;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.test_coding.DepartementEntity;
import com.service.service.repository.test_coding.DepartementRepository;

 
@Service
public class DepartementService extends CommonUtil { 
@Autowired
    DepartementRepository repository;

    public DepartementEntity save(DepartementEntity entity) {
        return repository.save(entity);
    }

    public DepartementEntity update(String id, DepartementEntity entity) {
        DepartementEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public DepartementEntity getById(String id) {
        // return repository.getById(id);
        Optional<DepartementEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<DepartementEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public Page<DepartementEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<DepartementEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<DepartementEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}