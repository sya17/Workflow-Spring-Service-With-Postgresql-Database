package com.service.service.dto.masterdata.workflow;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WorkflowGroupDTO {

    private String id;

    @NotEmpty(message = "name_workflow_group must be field")
    @Max(value = 100, message = "name_workflow_group 100 Character")
    private String name_workflow_group;
    private String description;
    private String active;
}
