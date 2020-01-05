package com.spring.poc.user.managment.feature.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Length(min = 5, max = 42)
    @Column(nullable = false, length = 42)
    private String name;

    @Length(min = 5, max = 42)
    @Column(nullable = false, length = 42)
    private String email;

    @Length(min = 5, max = 42)
    @Column(nullable = false, length = 42)
    private String password;
}
