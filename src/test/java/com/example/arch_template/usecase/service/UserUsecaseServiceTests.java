package com.example.arch_template.usecase.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.arch_template.domain.model.UserData;
import com.example.arch_template.domain.repository.UserRepository;
import com.example.arch_template.infrastructure.entity.UserEntity;
import com.example.arch_template.usecase.mapper.UserUsecaseMapper;

class UserUsecaseServiceTests {

    @Mock
    private UserUsecaseMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserUsecaseService userUsecaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUser_UserFound() {
        // Arrange
        String id = "test@example.com";
        UserEntity mockUserEntity = new UserEntity();
        UserData mockUserData = new UserData(id, "Test User", "test@example.com");
        when(userRepository.findById(id)).thenReturn(Optional.of(mockUserEntity));
        when(userMapper.toUserData(mockUserEntity)).thenReturn(mockUserData);

        // Act
        UserData result = userUsecaseService.getUser(id);

        // Assert
        assertEquals(mockUserData, result);
        verify(userRepository).findById(id);
        verify(userMapper).toUserData(mockUserEntity);
    }

    @Test
    void testGetUser_UserNotFound() {
        // Arrange
        String id = "test@example.com";
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> userUsecaseService.getUser(id));
        verify(userRepository).findById(id);
        verifyNoInteractions(userMapper);
    }

    @Test
    void testCreateUser() {
        // Arrange
        String id = "john";
        String name = "John Doe";
        String email = "john@example.com";
        UserData userData = new UserData(id, name, email);
        UserEntity mockUserEntity = new UserEntity();
        mockUserEntity.setId(id);
        mockUserEntity.setName(name);
        mockUserEntity.setEmail(email);

        when(userMapper.toUserEntity(userData)).thenReturn(mockUserEntity);

        // Act
        userUsecaseService.createUser(userData);

        // Assert
        verify(userMapper).toUserEntity(userData);
        verify(userRepository).save(mockUserEntity);
    }
}