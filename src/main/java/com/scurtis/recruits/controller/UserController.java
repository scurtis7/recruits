package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.storage.UserAccountDataAccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserAccountDataAccess dataAccess;

    @PostMapping("api/user")
    public String createUserAccount(@RequestBody SiteUser siteUser) {
        log.debug("createUserAccount() method called");
//        SiteUser user = dataAccess.saveUserAccount(siteUser);
        return "Success";
    }

}
