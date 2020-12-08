package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.UserAccount;
import com.scurtis.recruits.storage.UserAccountDataAccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class AccountController {

    private final UserAccountDataAccess dataAccess;

    @PostMapping("/account")
    public UserAccount createUserAccount(@RequestBody UserAccount userAccount) {
        return dataAccess.saveUserAccount(userAccount);
    }

}
