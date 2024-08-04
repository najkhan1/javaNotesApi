package com.najkhan.javaNotesApi.model.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private Integer id;
    private String email;

    private String password;

    private String fullName;
}
