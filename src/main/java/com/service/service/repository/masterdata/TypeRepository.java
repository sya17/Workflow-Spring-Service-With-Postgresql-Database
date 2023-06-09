
package com.service.service.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.service.service.entity.masterdata.TypeEntity;
 
public interface TypeRepository extends JpaRepository<TypeEntity, String> { 
 
}