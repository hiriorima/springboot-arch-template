package com.example.arch_template.presentation.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

	private String id;

	private String name;

	private String email;

}
