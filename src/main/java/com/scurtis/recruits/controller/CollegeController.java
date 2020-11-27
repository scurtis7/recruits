package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.College;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@RestController
public class CollegeController {

    @GetMapping("colleges")
    public List<College> getAllColleges() {
        List<College> colleges = new ArrayList<>();
        College college = new College();
        college.setConference("ACC");
        college.setDisplayName("Florida State University");
        college.setDivision("Atlantic");
        college.setId(1);
        college.setSiteName("");
        colleges.add(college);
        return colleges;
    }

}
