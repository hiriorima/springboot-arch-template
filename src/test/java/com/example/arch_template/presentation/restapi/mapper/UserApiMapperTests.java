
package com.example.arch_template.presentation.restapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.example.arch_template.domain.model.UserData;
import com.example.arch_template.presentation.restapi.dto.UserRequest;
import com.example.arch_template.presentation.restapi.dto.UserResponse;

class UserApiMapperTests {

    private UserApiMapper userApiMapper;

    @BeforeEach
    void setUp() {
        userApiMapper = Mappers.getMapper(UserApiMapper.class);
    }

    @Test
    void testToUserData() {
        // Arrange
        UserRequest userRequest = new UserRequest("john" ,"test@example.com", "John Doe");
 
        // Act
        UserData userData = userApiMapper.toUserData(userRequest);

        // Assert
        assertEquals(userRequest.getEmail(), userData.getEmail());
        assertEquals(userRequest.getName(), userData.getName());
    }

    @Test
    void testToUserResponse() {
        // Arrange
        UserData userData = new UserData("john", "test@example.com", "John Doe");

        // Act
        UserResponse userResponse = userApiMapper.toUserResponse(userData);

        // Assert
        assertEquals(userData.getEmail(), userResponse.getEmail());
        assertEquals(userData.getName(), userResponse.getName());
    }
}