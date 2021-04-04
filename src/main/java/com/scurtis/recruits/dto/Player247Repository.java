package com.scurtis.recruits.dto;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

public interface Player247Repository extends JpaRepository<Player247, Integer> {

    List<Player247> findPlayer247ByCollege(String college);

    List<Player247> findPlayer247ByCollegeAndYear(String college, Integer year);

    List<Player247> findPlayer247ByCollegeAndPosition(String college, String position);

    @Query("SELECT DISTINCT p.year FROM Player247 p WHERE p.college = ?1")
    List<Integer> findDistinctYearsByCollege(String collge);

    @Query("SELECT DISTINCT p.position FROM Player247 p WHERE p.college = ?1")
    List<String> findDistinctPositionsByCollege(String college);

}
