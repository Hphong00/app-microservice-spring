package com.app.userservice.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean status;
    private String role;
}
