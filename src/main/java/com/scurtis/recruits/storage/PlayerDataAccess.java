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

    public List<Player247> getAllPlayers() {
        return player247Repository.findAll();
    }

}
