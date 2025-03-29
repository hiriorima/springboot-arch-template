package com.example.arch_template.presentation.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arch_template.presentation.restapi.dto.UserRequest;
import com.example.arch_template.presentation.restapi.dto.UserResponse;
import com.example.arch_template.presentation.restapi.mapper.UserApiMapper;
import com.example.arch_template.usecase.service.UserUsecaseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserApiMapper userMapper;
    private final UserUsecaseService userUsecaseService;

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String email) {
        UserResponse userResponse = userMapper.toUserResponse(userUsecaseService.getUser(email));
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(UserRequest userRequest) {
        userUsecaseService.createUser(userMapper.toUserData(userRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}