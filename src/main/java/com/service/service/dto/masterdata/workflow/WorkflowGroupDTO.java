package com.service.service.dto.masterdata.workflow;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WorkflowGroupDTO {

    private String id;

    @NotEmpty(message = "name_workflow_group must be field")
    private String name_workflow_group;

    @NotEmpty(message = "id_transaction must be field")
    private String id_transaction;

    @NotEmpty(message = "tabel_name must be field")
    private String tabel_name;

    private String description;

    private String active;
}
