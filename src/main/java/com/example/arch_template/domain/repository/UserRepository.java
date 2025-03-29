package com.example.arch_template.domain.repository;

import java.util.Optional;

import com.example.arch_template.infrastructure.entity.UserEntity;

public interface UserRepository {
    Optional<UserEntity> findById(String id);
    void save(UserEntity user);
}
