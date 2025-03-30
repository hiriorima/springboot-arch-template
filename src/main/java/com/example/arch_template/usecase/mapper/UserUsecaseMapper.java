package com.example.arch_template.usecase.mapper;

import org.mapstruct.Mapper;

import com.example.arch_template.domain.model.UserData;
import com.example.arch_template.infrastructure.config.ConfigMapper;
import com.example.arch_template.infrastructure.entity.UserEntity;

@Mapper(config = ConfigMapper.class)
public interface UserUsecaseMapper {

	UserData toUserData(UserEntity userEntity);

	UserEntity toUserEntity(UserData userData);

}
