package com.spring.poc.user_feature.user_managment.command;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserCommand {

    @Length(min = 5, max = 42)
    private String name;

    @Length(min = 5, max = 42)
    private String email;
}
