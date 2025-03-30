package com.example.arch_template.presentation.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // MockMVCのテストで使用するために必要
public class UserRequest {

	private String id;

	private String name;

	private String email;

}
