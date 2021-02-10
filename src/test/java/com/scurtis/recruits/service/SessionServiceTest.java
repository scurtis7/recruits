package com.scurtis.recruits.service;

import com.scurtis.recruits.dto.Role;
import com.scurtis.recruits.dto.Session;
import com.scurtis.recruits.dto.SessionRepository;
import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.exceptions.InvalidTokenException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class SessionServiceTest {

    private static final String GOOD_BEARER_TOKEN = "Bearer username|password";

    SessionService sessionService;

    @Mock
    private UserService userServiceMock;

    @Mock
    private SessionRepository repositoryMock;

    @BeforeEach
    void setup() {
        sessionService = new SessionService(userServiceMock, repositoryMock);
    }

    @Test
    void testLoginSuccess() {
        when(userServiceMock.login("username", "password")).thenReturn(getSiteUser());
        doNothing().when(repositoryMock).removeSession("username");
        when(repositoryMock.save(any())).thenReturn(getSession());
        when(repositoryMock.existsById(1)).thenReturn(false);
        Session session = sessionService.login(GOOD_BEARER_TOKEN);
        Assertions.assertNotNull(session);
    }

    @Test
    void testLoginWithTokenMissingBearer() {
        Exception exception = assertThrows(InvalidTokenException.class, () -> sessionService.login("bad token"));
        String expectedMessage = "The token should be a 'Bearer' token";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testLoginWithTokenMissingUsernamePassword() {
        Exception exception = assertThrows(InvalidTokenException.class, () -> {
            sessionService.login("Bearer bad token");
        });
        String expectedMessage = "The token should include the username and password";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private SiteUser getSiteUser() {
        SiteUser user = new SiteUser();
        user.setId(1);
        user.setUsername("Full Name");
        user.setUsername("username");
        user.setPassword("password");
        user.setRole(Role.GUEST);
        user.setCollege("college");
        return user;
    }

    private Session getSession() {
        SiteUser user = getSiteUser();
        Session session = new Session();
        session.setId(1);
        session.setCreated(LocalDateTime.now());
        session.setExpiration(30);
        session.setUsername(user.getUsername());
        session.setRole(user.getRole());
        session.setCollege(user.getCollege());
        return session;
    }

}
