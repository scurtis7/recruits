package com.scurtis.recruits.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PasswordManagerTest {

    private static PasswordManager passwordManager;

    @BeforeAll
    static void setup() {
        passwordManager = new PasswordManager(new BCryptPasswordEncoder());
    }

    @Test
    void encodePassword_ReturnsGoodResult() {
        String rawPassword = "ThePassword123!@#";
        String encodedPwd = passwordManager.getEncodedPassword(rawPassword);
        assertNotNull(encodedPwd);
    }

    @Test
    void encodePassword_WithEmptyString_ReturnsNotNull() {
        String rawPassword = "";
        String encodedPwd = passwordManager.getEncodedPassword(rawPassword);
        assertNotNull(encodedPwd);
    }

    @Test
    void encodePassword_WithLongString_ReturnsNotNull() {
        String rawPassword = "This is a really long string to do a test to encode a really long password 1234567890!@#$%^&*()_+=-This is a really long string to do a test to encode a really long password 1234567890!@#$%^&*()_+=-This is a really long string to do a test to encode a really long password 1234567890!@#$%^&*()_+=-";
        String encodedPwd = passwordManager.getEncodedPassword(rawPassword);
        assertNotNull(encodedPwd);
    }

    @Test
    void passwordsMatch_ReturnsTrue_WhenTheCorrectPasswordIsSent() {
        String rawPassword = "ThePassword123!@#";
        String encodedPwd = passwordManager.getEncodedPassword(rawPassword);
        Assertions.assertTrue(passwordManager.passwordsMatch(rawPassword, encodedPwd));
    }

    @Test
    void passwordsMatch_ReturnsFalse_WhenTheIncorrectPasswordIsSent() {
        String rawPassword = "ThePassword123!@#";
        String wrongPassword = "ThePassword321!@#";
        String encodedPwd = passwordManager.getEncodedPassword(rawPassword);
        Assertions.assertFalse(passwordManager.passwordsMatch(wrongPassword, encodedPwd));
    }

}
