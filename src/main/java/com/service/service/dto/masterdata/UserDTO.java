package com.service.service.dto.masterdata;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {

    private String id;

    // @Max(value = 100, message = "name_m_user Max 100 Character")
    @NotEmpty(message = "name_m_user must be field")
    private String name_m_user;

    // @Max(value = 100, message = "Max username 100 Character")
    // @Min(value = 7, message = "Min username 7 Character")
    @NotEmpty(message = "username must be field")
    private String username;

    // @Max(value = 100, message = "Max password 100 Character")
    // @Min(value = 7, message = "Min password 7 Character")
    @NotEmpty(message = "password must be field")
    private String password;

    @NotEmpty(message = "email must be field")
    @Email(message = "Is not email")
    private String email;
    
    private String active;
}
