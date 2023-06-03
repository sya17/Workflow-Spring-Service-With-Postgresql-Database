package com.service.service.dto.masterdata;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {

    private String id;

    @NotEmpty(message = "name_m_user must be field")
    @Max(value = 100, message = "name_m_user 100 Character")
    private String name_m_user;

    @NotEmpty(message = "username must be field")
    @Max(value = 100, message = "Max username 100 Character")
    @Min(value = 7, message = "Min username 7 Character")
    private String username;

    @NotEmpty(message = "password must be field")
    @Max(value = 100, message = "Max password 100 Character")
    @Min(value = 7, message = "Min password 7 Character")
    private String password;

    @NotEmpty(message = "email must be field")
    @Email(message = "Is not email")
    private String email;
}
