
package com.service.service.dto.masterdata.workflow.workflowcondition;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

 
 

@Data
public class WorkflowConditionDTO { 
 
     private String id;
     private String name_m_condition;
     private String operation;
     private String field_name;
     private String value_condition;



     private String active;
}