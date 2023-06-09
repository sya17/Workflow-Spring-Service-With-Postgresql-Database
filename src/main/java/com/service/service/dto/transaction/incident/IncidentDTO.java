
package com.service.service.dto.transaction.incident;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
 
 

@Data
public class IncidentDTO { 
 
     private String id;

     private String active;
}