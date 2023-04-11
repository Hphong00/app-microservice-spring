package com.app.userservice.service;


import com.app.userservice.dto.SignUpRequest;

public interface UserService {
    public String signUpUser(SignUpRequest signUpRequest);
}
