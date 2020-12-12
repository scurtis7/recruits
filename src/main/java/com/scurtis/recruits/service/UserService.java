package com.scurtis.recruits.service;

import com.scurtis.recruits.dto.Role;
import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.storage.UserAccountDataAccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Steve Curtis
 * Date: Dec 11, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserAccountDataAccess dataAccess;
    private final PasswordManager passwordManager;

    public SiteUser saveUser(SiteUser siteUser) {
        log.info("Saving user: " + siteUser.getUsername());
        String hashedPassword = passwordManager.getEncodedPassword(siteUser.getPassword());
        siteUser.setPassword(hashedPassword);
        siteUser.setRole(Role.GUEST);
        SiteUser user = dataAccess.saveUserAccount(siteUser);
        // secure the password by not returning it
        user.setPassword("");
        log.info("User saved successfully");
        return user;
    }

//    public boolean login(String username, String password) {
//        SiteUser user = dataAccess
//    }


}
