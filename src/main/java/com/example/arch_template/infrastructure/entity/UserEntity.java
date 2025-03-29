package com.example.arch_template.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Id
    @Column(length = 20)
    private String id;

    private String name;
    
    private String email;
}
