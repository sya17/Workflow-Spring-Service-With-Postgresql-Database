
package com.service.service.entity.test_coding;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.service.service.entityListener.test_coding.DepartementEntityListener;

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
@Table(name = "r_departement")
@EntityListeners(DepartementEntityListener.class) 
 
public class DepartementEntity { 
 

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "sys_id_m_departement", updatable = false, nullable = false)
    private String id;

    @Column( name = "name_r_departement" )
    private String name_r_departement;

    @Column( name = "username" )
    private String username;

    @Column( name = "nama_depan" )
    private String nama_depan;

    @Column( name = "nama_belakang" )
    private String nama_belakang;

    @Column( name = "alamat"  ,columnDefinition = "TEXT")
    private String alamat;

    @Column( name = "departement_id" )
    private String departement_id;

    @CreatedDate
    @Column(name = "created")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updatedAt;

    @Column(name = "active", nullable = true, length = 1)
    private String active;

}