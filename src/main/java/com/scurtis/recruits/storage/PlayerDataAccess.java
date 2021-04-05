package com.scurtis.recruits.storage;

import com.scurtis.recruits.dto.Player247;
import com.scurtis.recruits.dto.Player247Repository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PlayerDataAccess {

    private final Player247Repository player247Repository;

    public List<Player247> getAllPlayersByCollege(String college) {
        return player247Repository.findPlayer247ByCollege(college);
    }

    public List<Player247> getPlayersByCollegeAndYear(String college, Integer year) {
        return player247Repository.findPlayer247ByCollegeAndYear(college, year);
    }

    public List<Player247> getPlayersByCollegeAndPosition(String college, String position) {
        return player247Repository.findPlayer247ByCollegeAndPosition(college, position);
    }

    public List<Integer> getDistinctYearsByCollege(String collge) {
        return player247Repository.findDistinctYearsByCollege(collge);
    }

    public List<String> getDistinctPositionsByCollege(String college) {
        return player247Repository.findDistinctPositionsByCollege(college);
    }

}
