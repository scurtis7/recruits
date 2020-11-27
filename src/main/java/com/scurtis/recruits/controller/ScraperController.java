package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.Player247;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@RestController
@Slf4j
public class ScraperController {

    @GetMapping("scrape/247/{college}/{year}")
    public List<Player247> scrape(@PathVariable String college, @PathVariable String year) {
        log.info("scrape method called with college:" + college + "    year:" + year);
        return new ArrayList<>();
    }
}
