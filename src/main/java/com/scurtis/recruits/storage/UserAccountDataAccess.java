package com.scurtis.recruits.storage;

import com.scurtis.recruits.dto.UserAccount;
import com.scurtis.recruits.dto.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class UserAccountDataAccess {

    private final UserAccountRepository repository;

    public UserAccount saveUserAccount(UserAccount userAccount) {
        return repository.save(userAccount);
    }

}
