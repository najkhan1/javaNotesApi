package com.najkhan.javaNotesApi.model.responses;

import lombok.Data;

@Data
public class SignupResponse {

    private String info;

    public SignupResponse(String email) {
        this.info = "Account created with username: " + email;
    }
}
