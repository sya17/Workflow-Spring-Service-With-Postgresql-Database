
package com.service.service.service.transaction.incident;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.transaction.incident.IncidentEntity;
import com.service.service.repository.transaction.incident.IncidentRepository;

 
@Service
public class IncidentService extends CommonUtil { 
@Autowired
    IncidentRepository repository;

    public IncidentEntity save(IncidentEntity entity) {
        return repository.save(entity);
    }

    public IncidentEntity update(String id, IncidentEntity entity) {
        IncidentEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public IncidentEntity getById(String id) {
        // return repository.getById(id);
        Optional<IncidentEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<IncidentEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public List<IncidentEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<IncidentEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}