package com.example.arch_template.infrastructure.persistence;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(UserRepositoryImpl.class)
public class UserRepositoryImplTest {

	// TODO: Add test case using DBUnit

}