package com.scurtis.recruits.service;

import com.scurtis.recruits.dto.Role;
import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.storage.UserAccountDataAccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author: Steve Curtis
 * Date: Dec 11, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserAccountDataAccess dataAccess;
    private final PasswordEncoder encoder;

    public SiteUser saveUser(SiteUser siteUser) {
        String hashedPassword = getEncodedPassword(siteUser.getPassword());
        siteUser.setPassword(hashedPassword);
        siteUser.setRole(Role.GUEST);
        SiteUser user = dataAccess.saveUserAccount(siteUser);
        user.setPassword("");
        return user;
    }

    private String getEncodedPassword(String password) {
        return encoder.encode(password);
    }

}
