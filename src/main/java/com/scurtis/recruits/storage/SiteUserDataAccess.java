package com.scurtis.recruits.storage;

import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.dto.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class SiteUserDataAccess {

    private final SiteUserRepository repository;

    public SiteUser saveUserAccount(SiteUser siteUser) {
        return repository.save(siteUser);
//        try {
//            return repository.save(siteUser);
//        } catch (DataIntegrityViolationException integrityException) {
//            log.error(integrityException.getMessage());
//            throw new DuplicateUsernameException("The username must be unique", integrityException);
//        }
    }

    public SiteUser findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

}
