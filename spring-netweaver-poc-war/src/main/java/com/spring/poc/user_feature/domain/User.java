package com.spring.poc.user_feature.domain;

import lombok.Data;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@EdmEntityType
@EdmEntitySet
@Data public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EdmKey
    private Long id;

    @Column(nullable = false, length = 42)
    @Length(min = 5, max = 42)
    @EdmProperty
    private String name;

    @Column(nullable = false, length = 42)
    @Length(min = 5, max = 42)
    @EdmProperty
    private String email;

    @Column(nullable = false, length = 42)
    @Length(min = 5, max = 42)
    @EdmProperty
    private String password;
}
