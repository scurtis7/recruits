package com.scurtis.recruits.dto;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Steve Curtis
 * Date: Dec 07, 2020
 **/

public interface UserAccountRepository extends JpaRepository<SiteUser, Integer> {
}
