package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.College;
import com.scurtis.recruits.storage.CollegeDataAccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeDataAccess dataAccess;

    @GetMapping("/colleges")
    public List<College> getAllColleges() {
        return dataAccess.getAllColleges();
    }

}
