package com.service.service.dto.masterdata.workflow.workflowcondition;

import com.service.service.entity.masterdata.workflow.WorkflowGroupEntity;

import lombok.Data;

@Data
public class WorkflowGroupConditionDTO {

    private String id;
    private WorkflowGroupEntity id_workflow_group;
    private String description;
    private String operation;
    private String field_name;
    private String value_condition;

}
