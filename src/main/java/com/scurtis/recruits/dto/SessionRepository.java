package com.scurtis.recruits.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Steve Curtis
 * Date: Dec 15, 2020
 **/

public interface SessionRepository extends JpaRepository<Session, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Session s WHERE s.username = :username")
    void removeSession(String username);

}
