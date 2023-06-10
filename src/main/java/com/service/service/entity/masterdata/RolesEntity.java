
package com.service.service.entity.masterdata;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.service.service.entityListener.masterdata.RolesEntityListener;

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

@Setter // Untuk Set Paramater
@Getter // Untuk Get Paramater
@Data // Untuk Memberikan Identitas Data yang mengakses ke Database
@Entity // Untuk Memberikan Identitas Data yang mengakses ke Database
@Table(name = "m_roles")
@EntityListeners(RolesEntityListener.class) 
 
public class RolesEntity { 
 

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "sys_id_m_roles", updatable = false, nullable = false)
    private String id;

    @Column( name = "name_m_roles"  ,length = 100 )
    private String name_m_roles;

    @Column( name = "description"  ,columnDefinition = "TEXT")
    private String description;

    @CreatedDate
    @Column(name = "created")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updatedAt;

    @Column(name = "active", nullable = true, length = 1)
    private String active;

}