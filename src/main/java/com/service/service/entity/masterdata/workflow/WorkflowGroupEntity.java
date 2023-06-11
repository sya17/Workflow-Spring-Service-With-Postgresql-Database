package com.service.service.entity.masterdata.workflow;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.service.service.entity.masterdata.UserEntity;
import com.service.service.entityListener.masterdata.workflow.WorkflowGroupEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter // Untuk Set Paramater
@Getter // Untuk Get Paramater
@Data // Untuk Memberikan Identitas Data yang mengakses ke Database
@Entity // Untuk Memberikan Identitas Data yang mengakses ke Database
@Table(name = "m_workflow_group")
@EntityListeners(WorkflowGroupEntityListener.class)
public class WorkflowGroupEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "sys_id_m_workflow_group", updatable = false, nullable = false)
    private String id;

    @Column(name = "name_m_workflow_group", nullable = true, length = 100)
    private String name_workflow_group;

    @Column(name = "sys_id_transaction")
    private String id_transaction;

    @Column(name = "tabel_name")
    private String tabel_name;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private UserEntity updatedBy;

    @CreatedDate
    @Column(name = "created")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updatedAt;

    @Column(name = "active", nullable = true, length = 1)
    private String active;
}
