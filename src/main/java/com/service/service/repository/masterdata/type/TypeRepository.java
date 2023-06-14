
package com.service.service.repository.masterdata.type;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.service.service.entity.masterdata.type.TypeEntity;
 
public interface TypeRepository extends JpaRepository<TypeEntity, String> { 
 
}