package com.scurtis.recruits.storage;

import com.scurtis.recruits.dto.College;
import com.scurtis.recruits.dto.CollegeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Nov 27, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class CollegeDataAccess {

    private final CollegeRepository repository;

    public List<College> getAllColleges() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "displayName"));
    }

}
