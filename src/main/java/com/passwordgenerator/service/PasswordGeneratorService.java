package com.passwordgenerator.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordGeneratorService {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";

    public String generatePassword(int length, boolean useUpperCase, boolean useLowerCase, boolean useNumbers, boolean useSpecialChars) {
        StringBuilder charPool = new StringBuilder();
        SecureRandom random = new SecureRandom();

        if (useUpperCase) {
            charPool.append(UPPER_CASE);
        }
        if (useLowerCase) {
            charPool.append(LOWER_CASE);
        }
        if (useNumbers) {
            charPool.append(NUMBERS);
        }
        if (useSpecialChars) {
            charPool.append(SPECIAL_CHARS);
        }

        if (charPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        return password.toString();
    }

    public String evaluatePasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) {
            score++;
        }
        if (password.matches(".*[A-Z].*")) {
            score++;
        }
        if (password.matches(".*[a-z].*")) {
            score++;
        }
        if (password.matches(".*[0-9].*")) {
            score++;
        }
        if (password.matches(".*[!@#$%^&*()-_+=<>?].*")) {
            score++;
        }

        return switch (score) {
            case 5 -> "Very Strong";
            case 4 -> "Strong";
            case 3 -> "Medium";
            case 2 -> "Weak";
            default -> "Very Weak";
        };
    }
}
