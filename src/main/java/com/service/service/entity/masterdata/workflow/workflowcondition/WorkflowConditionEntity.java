
package com.service.service.entity.masterdata.workflow.workflowcondition;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.service.service.entityListener.masterdata.workflow.workflowcondition.WorkflowConditionEntityListener;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.service.service.entity.masterdata.workflow.WorkflowEntity;
import com.service.service.entity.masterdata.UserEntity;
@Setter // Untuk Set Paramater
@Getter // Untuk Get Paramater
@Data // Untuk Memberikan Identitas Data yang mengakses ke Database
@Entity // Untuk Memberikan Identitas Data yang mengakses ke Database
@Table(name = "m_workflowcondition")
@EntityListeners(WorkflowConditionEntityListener.class) 
 
public class WorkflowConditionEntity { 
 

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "sys_id_m_workflowcondition", updatable = false, nullable = false)
    private String id;

    @Column( name = "name_m_condition"  ,length = 100 )
    private String name_m_condition;

    @Column( name = "operation" )
    private String operation;

    @Column( name = "field_name" )
    private String field_name;

    @Column( name = "value_condition" )
    private String value_condition;

    @ManyToOne()
    @JoinColumn( name = "sys_id_m_workflow"  )
    private WorkflowEntity sys_id_m_workflow;

    @ManyToOne()
    @JoinColumn( name = "created_by"  )
    private UserEntity created_by;

    @ManyToOne()
    @JoinColumn( name = "updated_by"  )
    private UserEntity updated_by;

    @CreatedDate
    @Column(name = "created")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updatedAt;

    @Column(name = "active", nullable = true, length = 1)
    private String active;

}