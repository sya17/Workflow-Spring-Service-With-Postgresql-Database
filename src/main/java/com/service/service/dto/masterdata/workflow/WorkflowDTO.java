
package com.service.service.dto.masterdata.workflow;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

 
 

@Data
public class WorkflowDTO { 
 
     private String id;
     private String name_m_workflow;
     private String tabel_name;
     private String description;



     private String active;
}