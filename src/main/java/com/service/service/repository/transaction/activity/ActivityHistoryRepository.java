
package com.service.service.repository.transaction.activity;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.service.service.entity.transaction.activity.ActivityHistoryEntity;
 
public interface ActivityHistoryRepository extends JpaRepository<ActivityHistoryEntity, String> { 
 
}