
package com.service.service.repository.transaction.incident;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.service.service.entity.transaction.incident.IncidentEntity;
 
public interface IncidentRepository extends JpaRepository<IncidentEntity, String> { 
 
}