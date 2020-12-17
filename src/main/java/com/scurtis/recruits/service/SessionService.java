package com.scurtis.recruits.service;

import com.scurtis.recruits.dto.Session;
import com.scurtis.recruits.dto.SessionRepository;
import com.scurtis.recruits.exceptions.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * Author: Steve Curtis
 * Date: Dec 15, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class SessionService {

    private final UserService userService;
    private final SessionRepository repository;

    public Session login(String token) {
        log.debug("login() method called");
        if (!token.startsWith("Bearer")) {
            throw new InvalidTokenException("The token should be a 'Bearer' token");
        }
        String temp = token.substring(7);
        String[] split = temp.split("\\|");
        if (split.length != 2) {
            throw new InvalidTokenException("The token should include the username and password");
        }
        String username = split[0];
        String password = split[1];

        if (!userService.login(username, password)) {
            throw new InvalidTokenException("User login failed");
        }

        Session session = new Session();
        session.setCreated(LocalDateTime.now());
        session.setExpiration(30);

        return repository.save(session);
    }

}
