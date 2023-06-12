
package com.service.service.repository.masterdata.location;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.service.service.entity.masterdata.location.LocationEntity;
 
public interface LocationRepository extends JpaRepository<LocationEntity, String> { 
 
}