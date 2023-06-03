package com.service.service.service.masterdata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.service.entity.masterdata.UserEntity;
import com.service.service.repository.masterdata.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository uRepository;

    public UserEntity save(UserEntity userModel) {
        return uRepository.save(userModel);
    }

    public UserEntity update(String id, UserEntity userModel) {
        Optional<UserEntity> user = getById(id);
        return (!user.isEmpty() ? uRepository.save(userModel) : null);
    }

    public Optional<UserEntity> getById(String id) {
        return uRepository.findById(id);
    }

    public List<UserEntity> getAll() {
        return uRepository.findAll();
    }

    public boolean deleteById(String id) {
        Optional<UserEntity> user = getById(id);
        if(!user.isEmpty()){
            uRepository.deleteById(id);
        }
        return !user.isEmpty();
    }

    public void deleteAll() {
        uRepository.deleteAll();
    }
}
