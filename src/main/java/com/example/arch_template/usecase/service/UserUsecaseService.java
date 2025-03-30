package com.example.arch_template.usecase.service;

import org.springframework.stereotype.Service;

import com.example.arch_template.domain.model.UserData;
import com.example.arch_template.domain.repository.UserRepository;
import com.example.arch_template.usecase.mapper.UserUsecaseMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserUsecaseService {

	private final UserUsecaseMapper userMapper;

	private final UserRepository userRepository;

	public UserData getUser(String id) {
		return userMapper
			.toUserData(userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found")));
	}

	public void createUser(UserData userData) {
		userRepository.save(userMapper.toUserEntity(userData));
	}

}
