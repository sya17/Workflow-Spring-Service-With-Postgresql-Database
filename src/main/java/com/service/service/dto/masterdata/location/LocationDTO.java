
package com.service.service.dto.masterdata.location;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

 
 

@Data
public class LocationDTO { 
 
     private String id;
     private String name_m_location;
     private String description;


     private String active;
}