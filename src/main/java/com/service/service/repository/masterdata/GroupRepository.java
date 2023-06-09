
package com.service.service.repository.masterdata;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.service.service.entity.masterdata.GroupEntity;
 
public interface GroupRepository extends JpaRepository<GroupEntity, String> { 
 
}