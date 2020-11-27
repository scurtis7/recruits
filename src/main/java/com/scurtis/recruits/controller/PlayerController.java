package com.scurtis.recruits.controller;

import com.scurtis.recruits.dto.Player247;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@RestController
public class PlayerController {

    @GetMapping("players")
    public List<Player247> getAllPlayers() {
        return new ArrayList<>();
    }

}
