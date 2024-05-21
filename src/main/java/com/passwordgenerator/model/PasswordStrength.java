package com.passwordgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PasswordStrength {
    private String password;
    private String strength;
}
