package com.scurtis.recruits.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.recruits.dto.ChangePassword;
import com.scurtis.recruits.dto.Role;
import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.exceptions.InvalidTokenException;
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

import static org.mockito.Mockito.doThrow;
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
    private static ChangePassword changePassword;

    @BeforeAll
    static void init() {
        user = getSiteUser();
        changePassword = getChangePassword();
    }

    @Test
    void testCreateUserAccountReturns200OK() throws Exception {
        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateUserAccountWithBadContentTypeReturns415UnsupportedMediaType() throws Exception {
        mockMvc.perform(post("/api/user")
                .contentType("text/plain")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    void testCreateUserAccountWithoutBodyReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testLoginUserReturns200OK() throws Exception {
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "12345"))
                .andExpect(status().isOk());
    }

    @Test
    void testLoginUserWithoutAuthorizationReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testLoginUserWithInvalidTokenReturns401Unauthorized() throws Exception {
        doThrow(new InvalidTokenException("The token should include the username and password"))
                .when(sessionService).login("12345");
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "12345"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testLoginUserWithBadContentTypeReturns415UnsupportedMediaType() throws Exception {
        mockMvc.perform(post("/api/login")
                .contentType("text/plain"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testChangePasswordReturns200OK() throws Exception {
        mockMvc.perform(post("/api/changePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(changePassword)))
                .andExpect(status().isOk());
    }

    @Test
    void testChangePasswordWithoutBodyReturns400BadRequest() throws Exception {
        mockMvc.perform(post("/api/changePassword")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testChangePasswordWithBadContentTypeReturns415UnsupportedMediaType() throws Exception {
        mockMvc.perform(post("/api/changePassword")
                .contentType("text/plain"))
                .andExpect(status().isUnsupportedMediaType());
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

    private static ChangePassword getChangePassword() {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setOldUsername("old_user_name");
        changePassword.setOldPassword("old_user_password");
        changePassword.setNewPassword("new_user_password");
        return changePassword;
    }


}
