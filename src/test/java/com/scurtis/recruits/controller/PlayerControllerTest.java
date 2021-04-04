package com.scurtis.recruits.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.recruits.dto.Player247;
import com.scurtis.recruits.service.SessionService;
import com.scurtis.recruits.service.UserService;
import com.scurtis.recruits.storage.PlayerDataAccess;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    private static List<Integer> years;
    private static List<String> positions;

    @BeforeAll
    static void init() {
        players = getPlayers();
        years = getYears();
        positions = getPositions();
    }

    @Test
    void testGetPlayersByCollegeSuccess() throws Exception {
        Mockito.when(playerDataAccess.getAllPlayersByCollege("university")).thenReturn(players);
        mockMvc.perform(get("/api/players/college/{college}", "university")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(players)));
    }

    @Test
    void testGetPlayersWithNoParameterReturns404NotFound() throws Exception {
        mockMvc.perform(get("/api/players/college/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetPlayersWithBadAcceptReturns406NotAcceptable() throws Exception {
        mockMvc.perform(get("/api/players/college/{college}", "university")
                .accept(MediaType.TEXT_PLAIN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    void testGetPlayersByCollegeAndYearSuccess() throws Exception {
        Mockito.when(playerDataAccess.getPlayersByCollegeAndYear("university", 2020)).thenReturn(players);
        mockMvc.perform(get("/api/players/college/{college}/year/{year}", "university", "2020")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(players)));
    }

    @Test
    void testGetPlayersByCollegeAndYearWithNoYearReturns404NotFound() throws Exception {
        mockMvc.perform(get("/api/players/college/{university}/year/", "university")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetPlayersByCollegeAndYearWithBadAcceptReturns406NotAcceptable() throws Exception {
        mockMvc.perform(get("/api/players/college/{college}/year/{year}", "university", 2020)
                .accept(MediaType.TEXT_PLAIN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    void testGetPlayersByCollegeAndPositionSuccess() throws Exception {
        Mockito.when(playerDataAccess.getPlayersByCollegeAndPosition("university", "position")).thenReturn(players);
        mockMvc.perform(get("/api/players/college/{college}/position/{position}", "university", "position")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(players)));
    }

    @Test
    void testGetPlayersByCollegeAndPositionWithNoYearReturns404NotFound() throws Exception {
        mockMvc.perform(get("/api/players/college/{university}/position/", "university")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetPlayersByCollegeAndPositionWithBadAcceptReturns406NotAcceptable() throws Exception {
        mockMvc.perform(get("/api/players/college/{college}/position/{position}", "university", "position")
                .accept(MediaType.TEXT_PLAIN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    void testGetDistinctYearsByCollegeSuccess() throws Exception {
        Mockito.when(playerDataAccess.getDistinctYearsByCollege("university")).thenReturn(years);
        mockMvc.perform(get("/api/distinct/years/college/{college}/", "university")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(years)));
    }

    @Test
    void testGetDistinctYearsByCollegeWithNoCollegeReturns404NotFound() throws Exception {
        mockMvc.perform(get("/api/distinct/years/college/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetDistinctYearsByCollegeWithBadAcceptReturns406NotAcceptable() throws Exception {
        mockMvc.perform(get("/api/distinct/years/college/{college}/", "university")
                .accept(MediaType.TEXT_PLAIN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    void testGetDistinctPositionsByCollegeSuccess() throws Exception {
        Mockito.when(playerDataAccess.getDistinctPositionsByCollege("university")).thenReturn(positions);
        mockMvc.perform(get("/api/distinct/positions/college/{college}/", "university")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(positions)));
    }

    @Test
    void testGetDistinctPositionsByCollegeWithNoCollegeReturns404NotFound() throws Exception {
        mockMvc.perform(get("/api/distinct/positions/college/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetDistinctPositionsByCollegeWithBadAcceptReturns406NotAcceptable() throws Exception {
        mockMvc.perform(get("/api/distinct/positions/college/{college}/", "university")
                .accept(MediaType.TEXT_PLAIN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
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

    private static List<Integer> getYears() {
        return Stream.of(2018, 2019, 2020, 2021, 2022)
                .collect(Collectors.toList());
    }

    private static List<String> getPositions() {
        return Stream.of("QB", "CB", "Running Back")
                .collect(Collectors.toList());
    }

}
