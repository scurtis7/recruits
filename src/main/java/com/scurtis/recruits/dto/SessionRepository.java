package com.scurtis.recruits.dto;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Steve Curtis
 * Date: Dec 15, 2020
 **/

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
