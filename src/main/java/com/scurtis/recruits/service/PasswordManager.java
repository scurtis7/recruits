package com.scurtis.recruits.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author: Steve Curtis
 * Date: Dec 12, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class PasswordManager {

    private final PasswordEncoder encoder;

    public String getEncodedPassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public boolean passwordsMatch(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }

}
