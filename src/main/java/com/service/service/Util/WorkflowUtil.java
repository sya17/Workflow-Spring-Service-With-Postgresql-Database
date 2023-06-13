package com.service.service.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.service.service.entity.masterdata.workflow.WorkflowEntity;
import com.service.service.repository.masterdata.workflow.WorkflowGroupRepository;
import com.service.service.repository.masterdata.workflow.WorkflowRepository;
import com.service.service.repository.masterdata.workflow.workflowcondition.WorkflowConditionRepository;
import com.service.service.repository.masterdata.workflow.workflowcondition.WorkflowGroupConditionRepository;

@Service
public class WorkflowUtil {

    private static WorkflowRepository workflowRepository;
    private static WorkflowConditionRepository workflowConditionRepository;
    private static WorkflowGroupRepository workflowGroupRepository;
    private static WorkflowGroupConditionRepository workflowGroupConditionRepository;

    public static WorkflowUtil INSTANCE = null;

    public static WorkflowUtil getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return new WorkflowUtil(workflowRepository, workflowConditionRepository, workflowGroupRepository,
                    workflowGroupConditionRepository);
        }
    }

    @Autowired
    public WorkflowUtil(WorkflowRepository workflowRepository,
            WorkflowConditionRepository workflowConditionRepository,
            WorkflowGroupRepository workflowGroupRepository,
            WorkflowGroupConditionRepository workflowGroupConditionRepository) {
        this.workflowRepository = workflowRepository;
        this.workflowConditionRepository = workflowConditionRepository;
        this.workflowGroupRepository = workflowGroupRepository;
        this.workflowGroupConditionRepository = workflowGroupConditionRepository;
    }

    public void startWorkflow(JpaRepository repo, String tableName) {
        try {
            System.out.println(">>>>> " + repo.findAll() + "\n");
            // System.out.println(">>>>> " + workflowRepository.findAll() + "\n");
            // System.out.println(">>>>> " + workflowConditionRepository.findAll() + "\n");
            // System.out.println(">>>>> " + workflowGroupRepository.findAll() + "\n");
            // System.out.println(">>>>> " + workflowGroupConditionRepository.findAll() +
            // "\n");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void stopWorkflow() {

    }
}
