package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.Player247;
import com.scurtis.recruits.storage.PlayerDataAccess;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerDataAccess dataAccess;

    @GetMapping("/players/college/{college}")
    public List<Player247> getPlayersByCollege(@PathVariable String college) {
        return dataAccess.getAllPlayersByCollege(college);
    }

    @GetMapping("/players/college/{college}/year/{year}")
    public List<Player247> getPlayersByCollegeAndYear(@PathVariable("college") String college, @PathVariable("year") String year) {
        return dataAccess.getPlayersByCollegeAndYear(college, Integer.parseInt(year));
    }

    @GetMapping("/players/college/{college}/position/{position}")
    public List<Player247> getPlayersByCollegeAndPosition(@PathVariable("college") String college, @PathVariable("position") String position) {
        return dataAccess.getPlayersByCollegeAndPosition(college, position);
    }

    @GetMapping("/distinct/years/college/{college}/")
    public List<Integer> getDistinctYearsByCollege(@PathVariable String college) {
        return dataAccess.getDistinctYearsByCollege(college);
    }

    @GetMapping("/distinct/positions/college/{college}/")
    public List<String> getDistinctPositionsByCollege(@PathVariable String college) {
        return dataAccess.getDistinctPositionsByCollege(college);
    }

}
