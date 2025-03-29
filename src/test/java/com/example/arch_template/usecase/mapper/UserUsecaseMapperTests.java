package com.example.arch_template.usecase.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.example.arch_template.domain.model.UserData;
import com.example.arch_template.infrastructure.entity.UserEntity;

class UserUsecaseMapperTest {

    private UserUsecaseMapper userUsecaseMapper;

    @BeforeEach
    void setUp() {
        userUsecaseMapper = Mappers.getMapper(UserUsecaseMapper.class);
    }

    @Test
    void testToUserData() {
        // Arrange
        UserEntity userEntity = new UserEntity();
        userEntity.setId("john");
        userEntity.setName("John Doe");
        userEntity.setEmail("john.doe@example.com");
        userEntity.setCreatedAt(LocalDateTime.now());
        userEntity.setUpdatedAt(LocalDateTime.now());

        // Act
        UserData userData = userUsecaseMapper.toUserData(userEntity);

        // Assert
        assertEquals(userEntity.getName(), userData.getName());
        assertEquals(userEntity.getEmail(), userData.getEmail());
    }

    @Test
    void testToUserEntity() {
        // Arrange
        UserData userData = new UserData("jane", "jane.doe@example.com", "Jane Doe");

        // Act
        UserEntity userEntity = userUsecaseMapper.toUserEntity(userData);

        // Assert
        assertEquals(userData.getName(), userEntity.getName());
        assertEquals(userData.getEmail(), userEntity.getEmail());
    }
}