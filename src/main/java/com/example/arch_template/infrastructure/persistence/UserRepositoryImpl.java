package com.example.arch_template.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.arch_template.domain.repository.UserRepository;
import com.example.arch_template.infrastructure.entity.UserEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserJpaRepository userJpaRepository;

	@Override
	public Optional<UserEntity> findById(String id) {
		return userJpaRepository.findById(id);
	}

	@Override
	public void save(UserEntity user) {
		userJpaRepository.save(user);
	}

}
