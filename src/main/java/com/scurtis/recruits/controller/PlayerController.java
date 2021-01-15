package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.Player247;
import com.scurtis.recruits.storage.PlayerDataAccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerDataAccess dataAccess;

    @GetMapping("/players")
    public List<Player247> getAllPlayers() {
        return dataAccess.getAllPlayers();
    }

}
