
package com.service.service.dto.transaction.activity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

 
 

@Data
public class ActivityDTO { 
 
     private String id;
     private String name_m_condition;
     private String transaction_id;
     private String activity_type;
     private String description;
     private String details;



     private String active;
}