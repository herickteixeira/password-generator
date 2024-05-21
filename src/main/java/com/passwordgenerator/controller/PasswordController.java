package com.passwordgenerator.controller;

import com.passwordgenerator.model.PasswordCriteria;
import com.passwordgenerator.model.PasswordStrength;
import com.passwordgenerator.service.PasswordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @Autowired
    private PasswordGeneratorService passwordGeneratorService;

    @PostMapping("/generate")
    public String generatePassword(@RequestBody PasswordCriteria criteria) {
        return passwordGeneratorService.generatePassword(
                criteria.getLength(),
                criteria.isUseUpperCase(),
                criteria.isUseLowerCase(),
                criteria.isUseNumbers(),
                criteria.isUseSpecialChars()
        );
    }

    @GetMapping("/strength")
    public PasswordStrength evaluatePasswordStrength(@RequestParam String password) {
        String strength = passwordGeneratorService.evaluatePasswordStrength(password);
        return new PasswordStrength(password, strength);
    }
}
