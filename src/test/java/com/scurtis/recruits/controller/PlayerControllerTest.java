package com.scurtis.recruits.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.recruits.dto.Player247;
import com.scurtis.recruits.service.SessionService;
import com.scurtis.recruits.service.UserService;
import com.scurtis.recruits.storage.PlayerDataAccess;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private SessionService sessionService;

    @MockBean
    private PlayerDataAccess playerDataAccess;

    private static List<Player247> players;

    @BeforeAll
    static void init() {
        players = getPlayers();
    }

    @Test
    void testGetAllPlayersSuccess() throws Exception {
        mockMvc.perform(get("/api/players")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//            .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//            .content(objectMapper.writeValueAsString(players)))
//            .andExpect(status().isOk());
    }

    private static List<Player247> getPlayers() {
        Player247 player = new Player247();
        player.setId(1L);
        player.setSiteId(1);
        player.setName("Name");
        player.setPosition("Position");
        player.setHeight("height");
        player.setWeight("weight");
        player.setHomeTown("Home Town");
        player.setHighSchool("High School");
        player.setYear(1);
        player.setCompositeRank("compositeRank");
        player.setRankNational(1);
        player.setRankPosition(1);
        player.setWelcomePagePlaylist("playlist");
        player.setRankState(1);
        player.setStars(1);
        player.setLink("link");
        player.setCollege("college");
        return Collections.singletonList(player);
    }

}
