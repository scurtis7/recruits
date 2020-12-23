package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.ChangePassword;
import com.scurtis.recruits.dto.Session;
import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.exceptions.FailedLoginException;
import com.scurtis.recruits.exceptions.InvalidTokenException;
import com.scurtis.recruits.service.SessionService;
import com.scurtis.recruits.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SessionService sessionService;

    @ResponseBody
    @PostMapping("api/user")
    public ResponseEntity<SiteUser> createUserAccount(@RequestBody SiteUser siteUser) {
        log.debug("createUserAccount() method called");
        SiteUser user = userService.saveUser(siteUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("api/login")
    public ResponseEntity<Session> loginUser(@RequestHeader String authorization) {
        log.debug("loginUser() method called");
        try {
            Session session = sessionService.login(authorization);
            return new ResponseEntity<>(session, HttpStatus.OK);
        } catch (InvalidTokenException | FailedLoginException exception) {
            log.error("Exception logging in: " + exception.getMessage());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @ResponseBody
    @PostMapping("api/changePassword")
    public ResponseEntity<SiteUser> changePassword(@RequestBody ChangePassword changePassword) {
        log.debug("changePassword() method called");
        SiteUser user = userService.changePassword(changePassword);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
