
package com.service.service.entity.masterdata.type;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.service.service.entityListener.masterdata.type.TypeEntityListener;

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

import com.service.service.entity.masterdata.UserEntity;
@Setter // Untuk Set Paramater
@Getter // Untuk Get Paramater
@Data // Untuk Memberikan Identitas Data yang mengakses ke Database
@Entity // Untuk Memberikan Identitas Data yang mengakses ke Database
@Table(name = "m_type")
@EntityListeners(TypeEntityListener.class) 
 
public class TypeEntity { 
 

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "sys_id_m_type", updatable = false, nullable = false)
    private String id;

    @Column( name = "name_m_type" )
    private String name_m_type;

    @Column( name = "description"  ,columnDefinition = "TEXT")
    private String description;

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