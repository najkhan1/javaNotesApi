package com.najkhan.javaNotesApi.model;

import lombok.Data;

@Data
public class RegisterUserDto {
    private Integer id;
    private String email;

    private String password;

    private String fullName;
}
