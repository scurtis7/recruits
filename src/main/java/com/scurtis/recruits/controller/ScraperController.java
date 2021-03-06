package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.Player247;
import com.scurtis.recruits.service.Two47Scraper;
import com.scurtis.recruits.service.WebScrapingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@Slf4j
@RestController
@RequestMapping(value = "/api/scrape")
@RequiredArgsConstructor
public class ScraperController {

    private final Two47Scraper scraper;

    @GetMapping("/{college}/{year}")
    public List<Player247> scrape(@PathVariable String college, @PathVariable String year) {
        log.info("scrape method called with college:" + college + "    year:" + year);
        return scraper.scrape(college, year);
    }

}
