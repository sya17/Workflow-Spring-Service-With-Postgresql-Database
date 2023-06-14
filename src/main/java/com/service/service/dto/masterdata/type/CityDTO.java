
package com.service.service.dto.masterdata.type;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

 
 

@Data
public class CityDTO { 
 
     private String id;
     private String name_m_city;
     private String description;


     private String active;
}