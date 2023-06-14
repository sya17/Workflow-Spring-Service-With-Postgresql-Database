
package com.service.service.service.masterdata.type;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.type.CityEntity;
import com.service.service.repository.masterdata.type.CityRepository;

 
@Service
public class CityService extends CommonUtil { 
@Autowired
    CityRepository repository;

    public CityEntity save(CityEntity entity) {
        return repository.save(entity);
    }

    public CityEntity update(String id, CityEntity entity) {
        CityEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public CityEntity getById(String id) {
        // return repository.getById(id);
        Optional<CityEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<CityEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public Page<CityEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<CityEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<CityEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}