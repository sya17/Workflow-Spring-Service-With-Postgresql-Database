
package com.service.service.service.masterdata.location;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.location.LocationEntity;
import com.service.service.repository.masterdata.location.LocationRepository;

 
@Service
public class LocationService extends CommonUtil { 
@Autowired
    LocationRepository repository;

    public LocationEntity save(LocationEntity entity) {
        return repository.save(entity);
    }

    public LocationEntity update(String id, LocationEntity entity) {
        LocationEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public LocationEntity getById(String id) {
        // return repository.getById(id);
        Optional<LocationEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<LocationEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public Page<LocationEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<LocationEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<LocationEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}