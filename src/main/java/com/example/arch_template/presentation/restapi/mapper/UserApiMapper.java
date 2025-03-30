package com.example.arch_template.presentation.restapi.mapper;

import org.mapstruct.Mapper;

import com.example.arch_template.domain.model.UserData;
import com.example.arch_template.infrastructure.config.ConfigMapper;
import com.example.arch_template.presentation.restapi.dto.UserRequest;
import com.example.arch_template.presentation.restapi.dto.UserResponse;

@Mapper(config = ConfigMapper.class)
public interface UserApiMapper {

	UserData toUserData(UserRequest userRequest);

	UserResponse toUserResponse(UserData userData);

}
