package com.service.service.service.masterdata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.service.Util.CommonUtil;
import com.service.service.entity.masterdata.UserEntity;
import com.service.service.repository.masterdata.UserRepository;

@Service
public class UserService extends CommonUtil {

    @Autowired
    UserRepository repository;

    public UserEntity save(UserEntity userModel) {
        return repository.save(userModel);
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
        return repository.findById(id);
    }

    public Page<UserEntity> getAll(Pageable page) {
        return repository.findAll(page);
    }

    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<UserEntity> user = getByIdOpt(id);
        if (!user.isEmpty()) {
            repository.deleteById(id);
        }
        return !user.isEmpty();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
