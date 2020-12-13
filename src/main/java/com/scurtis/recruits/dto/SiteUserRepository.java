package com.scurtis.recruits.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

public interface SiteUserRepository extends JpaRepository<SiteUser, Integer> {

    @Query("SELECT u FROM SiteUser u WHERE u.username = ?1")
    SiteUser findUserByUsername(String username);

}
