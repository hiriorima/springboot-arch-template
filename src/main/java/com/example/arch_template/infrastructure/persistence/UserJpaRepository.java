package com.example.arch_template.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.arch_template.infrastructure.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
}
