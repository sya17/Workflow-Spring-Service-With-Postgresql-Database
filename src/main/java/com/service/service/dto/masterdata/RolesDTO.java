
package com.service.service.dto.masterdata;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

 
 

@Data
public class RolesDTO { 
 
     private String id;
     private String name_m_roles;
     private String description;
     private String active;
}