package com.passwordgenerator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordCriteria {
    private int length;
    private boolean useUpperCase;
    private boolean useLowerCase;
    private boolean useNumbers;
    private boolean useSpecialChars;
}
