
package com.service.service.service.test_coding;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.test_coding.UserEntity;
import com.service.service.repository.test_coding.UserRepository;

 
@Service
public class UserService extends CommonUtil { 
@Autowired
    UserRepository repository;

    public UserEntity save(UserEntity entity) {
        return repository.save(entity);
    }

    public UserEntity update(String id, UserEntity entity) {
        UserEntity entityB4 = getById(id);
        mergeEntity(entity, entityB4);
        return (entity != null && entityB4 != null ? repository.save(entityB4) : null);
    }

    public UserEntity getById(String id) {
        // return repository.getById(id);
        Optional<UserEntity> entity = getByIdOpt(id);
        return !entity.isPresent() ? null : entity.get();
    }

    public Optional<UserEntity> getByIdOpt(String id) {
        return !isNullOrEmpty(id) ? repository.findById(id) : null;
    }

    public Page<UserEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<UserEntity> entityB4 = getByIdOpt(id);
        if (!entityB4.isEmpty()) {
            repository.deleteById(id);
        }
        return !entityB4.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }}