
package com.service.service.repository.test_coding;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.service.service.entity.test_coding.UserEntity;
 
public interface UserRepository extends JpaRepository<UserEntity, String> { 
 
}