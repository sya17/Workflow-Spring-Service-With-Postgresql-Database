
package com.service.service.dto.test_coding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

 
 

@Data
public class UserDTO { 
 
     private String id;
     private String name_r_user;
     private String username;
     private String nama_depan;
     private String nama_belakang;
     private String alamat;
     private String departement_id;
     private String active;
}