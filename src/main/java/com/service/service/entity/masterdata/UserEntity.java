package com.service.service.entity.masterdata;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "m_user")
public class UserEntity {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "sys_id_m_user", updatable = false, nullable = false)
    private String id;

    @Column(name = "name_m_user", nullable = true)
    private String nameMUser;

    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "email", nullable = true)
    private String email;

    @CreatedDate
    @Column(name = "created")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @Column(name = "active", nullable = true)
    private String active;
}
