package com.scurtis.recruits.service;

import com.scurtis.recruits.exceptions.WebScrapingException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

@Slf4j
public class WebScrapingService {

    public Document scrape(String website) throws WebScrapingException {
        log.info("Connect to Website: {}", website);
        try {
            return Jsoup.connect(website).get();
        } catch (IOException exception) {
            log.error("Unable to get rivals website: {}", exception.getMessage());
            throw new WebScrapingException("Unable to get rivals website: " + exception.getMessage(), exception);
        }
    }

}
