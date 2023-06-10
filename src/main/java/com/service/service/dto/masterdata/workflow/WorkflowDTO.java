
package com.service.service.dto.masterdata.workflow;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import com.service.service.entity.masterdata.workflow.WorkflowGroupEntity;
import com.service.service.entity.masterdata.UserEntity;
 
 

@Data
public class WorkflowDTO { 
 
     private String id;
     private String name_m_type;
     private String description;
     private WorkflowGroupEntity sys_id_m_workflow_group;
     private UserEntity created_by;
     private UserEntity updated_by;
     private String active;
}