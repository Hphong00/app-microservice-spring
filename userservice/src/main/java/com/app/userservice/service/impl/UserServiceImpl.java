package com.app.userservice.service.impl;

import com.app.userservice.dto.KeycloakUser;
import com.app.userservice.dto.SignUpRequest;
import com.app.userservice.entity.Users;
import com.app.userservice.repository.UserRepository;
import com.app.userservice.service.KeycloakService;
import com.app.userservice.service.UserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    private final UserRepository userRepository;
    private final KeycloakService keycloakService;

    @Override
    public String signUpUser(SignUpRequest signUpRequest) {

        LOGGER.info("UserServiceImpl | signUpUser is started");

        KeycloakUser keycloakUser = new KeycloakUser();
        keycloakUser.setFirstName(signUpRequest.getFirstName());
        keycloakUser.setLastName(signUpRequest.getLastName());
        keycloakUser.setEmail(signUpRequest.getEmail());
        keycloakUser.setPassword(signUpRequest.getPassword());
        keycloakUser.setRole(signUpRequest.getRole());
        keycloakUser.setUsername(signUpRequest.getUsername());

        int status = keycloakService.createUserWithKeycloak(keycloakUser);

        if(status == 201){

            LOGGER.info("UserServiceImpl | signUpUser | status : " + status);

            Users user =  mapper.convertValue(keycloakUser, Users.class);

            userRepository.save(user);
            return "Sign Up completed";
        }

        return "Not Register";
    }
}
