package com.service.service.repository.masterdata.workflow.workflowcondition;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.service.entity.masterdata.workflow.workflowcondition.WorkflowGroupConditionEntity;

public interface WorkflowGroupConditionRepository extends JpaRepository<WorkflowGroupConditionEntity, String> {

}
