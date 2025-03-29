package com.example.arch_template.presentation.restapi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.arch_template.domain.model.UserData;
import com.example.arch_template.presentation.restapi.dto.UserRequest;
import com.example.arch_template.presentation.restapi.dto.UserResponse;
import com.example.arch_template.presentation.restapi.mapper.UserApiMapper;
import com.example.arch_template.usecase.service.UserUsecaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserApiMapper userMapper;

    @MockitoBean
    private UserUsecaseService userUsecaseService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGetUser_UserFound() throws Exception {
        // Arrange
        String id = "john";
        String email = "test@example.com";
        String name = "John Doe";
        UserResponse userResponse = new UserResponse(id, name, email);
        UserData userData = new UserData(id, name, email);
        when(userUsecaseService.getUser(id)).thenReturn(userData);
        when(userMapper.toUserResponse(any())).thenReturn(userResponse);

        // Act & Assert
        mockMvc.perform(get("/users/{id}", id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.name").value(name));

        verify(userUsecaseService).getUser(id);
        verify(userMapper).toUserResponse(userData);
    }

    // TODO: Add test for user not found

    @Test
    void testCreateUser_Success() throws Exception {
        // Arrange
        String id = "new";
        String email = "newuser@example.com";
        String name = "New User";
        UserRequest userRequest = new UserRequest(id, name, email);
        UserData userData = new UserData(id, name, email);

        doNothing().when(userUsecaseService).createUser(any());
        when(userMapper.toUserData(any())).thenReturn(userData);

        // Act & Assert
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isCreated());

        verify(userMapper).toUserData(any());
        verify(userUsecaseService).createUser(any());
    }
}