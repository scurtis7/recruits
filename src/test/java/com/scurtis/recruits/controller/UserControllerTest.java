package com.scurtis.recruits.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.recruits.dto.Role;
import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.service.SessionService;
import com.scurtis.recruits.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private SessionService sessionService;

    private static SiteUser user;

    @BeforeAll
    static void init() {
        user = getSiteUser();
    }

    @Test
    void createUserAccountSuccess() throws Exception {
        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void createUserAccountWithBadContentTypeReturns415UnsupportedMediaType() throws Exception {
        mockMvc.perform(post("/api/user")
                .contentType("text/plain")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    void createUserAccountWithoutBodyReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    private static SiteUser getSiteUser() {
        SiteUser user = new SiteUser();
        user.setId(1);
        user.setFullname("fullname");
        user.setUsername("username");
        user.setPassword("password");
        user.setRole(Role.GUEST);
        user.setCollege("college");
        return user;
    }


}
