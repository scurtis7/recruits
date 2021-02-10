package com.scurtis.recruits.service;

import com.scurtis.recruits.dto.ChangePassword;
import com.scurtis.recruits.dto.SiteUser;
import com.scurtis.recruits.exceptions.DuplicateUsernameException;
import com.scurtis.recruits.exceptions.FailedLoginException;
import com.scurtis.recruits.storage.SiteUserDataAccess;
import java.sql.SQLException;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    UserService userService;

    @Mock
    PasswordManager passwordManagerMock;

    @Mock
    SiteUserDataAccess dataAccessMock;

    @BeforeEach
    void setup() {
        userService = new UserService(dataAccessMock, passwordManagerMock);
    }

    @Test
    void saveUserSuccess() {
        SiteUser siteUserToSave = getSiteUser();
        when(dataAccessMock.saveUserAccount(siteUserToSave)).thenReturn(getSiteUser());
        SiteUser result = userService.saveUser(siteUserToSave);
        assertFalse(StringUtils.hasText(result.getPassword()));
    }

    @Test
    void saveUserThrowsDuplicateUsernameException() {
        SiteUser siteUserToSave = getSiteUser();
        when(dataAccessMock.saveUserAccount(siteUserToSave))
                .thenThrow(new ConstraintViolationException("Constraint Violation", new SQLException(), "Username is not unique"));
        Exception exception = assertThrows(DuplicateUsernameException.class, () -> userService.saveUser(siteUserToSave));
        String expectedMessage = "Constraint Violation";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));
    }

    @Test
    void loginSuccess() {
        SiteUser siteUser = getSiteUser();
        when(dataAccessMock.findUserByUsername("username")).thenReturn(siteUser);
        when(passwordManagerMock.passwordsMatch(anyString(), anyString())).thenReturn(true);
        SiteUser result = userService.login("username", "password");
        assertTrue(result.getCollege().equalsIgnoreCase("college"));
    }

    @Test
    void loginFailure() {
        SiteUser siteUser = getSiteUser();
        when(dataAccessMock.findUserByUsername("username")).thenReturn(siteUser);
        when(passwordManagerMock.passwordsMatch(anyString(), anyString())).thenReturn(false);
        Exception exception = assertThrows(FailedLoginException.class, () -> userService.login("username", "password"));
        String expectedMessage = "User passwords don't match";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));
    }

    @Test
    void changePasswordSuccess() {
        ChangePassword changePassword = getChangePassword();
        SiteUser siteUser = getSiteUser();
        when(dataAccessMock.findUserByUsername("username")).thenReturn(siteUser);
        when(passwordManagerMock.passwordsMatch(anyString(), anyString())).thenReturn(true);
        when(passwordManagerMock.getEncodedPassword("newPassword")).thenReturn("hashedPassword");
        when(dataAccessMock.saveUserAccount(siteUser)).thenReturn(getSiteUser());
        SiteUser result = userService.changePassword(changePassword);
        assertTrue(result.getCollege().equalsIgnoreCase("college"));
    }

    @Test
    void changePasswordFailure() {
        ChangePassword changePassword = getChangePassword();
        SiteUser siteUser = getSiteUser();
        when(dataAccessMock.findUserByUsername("username")).thenReturn(siteUser);
        when(passwordManagerMock.passwordsMatch(anyString(), anyString())).thenReturn(false);
        Exception exception = assertThrows(FailedLoginException.class, () -> userService.changePassword(changePassword));
        String expectedMessage = "User passwords don't match";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));
    }

    private SiteUser getSiteUser() {
        SiteUser siteUser = new SiteUser();
        siteUser.setFullname("fullname");
        siteUser.setUsername("username");
        siteUser.setPassword("password");
        siteUser.setCollege("college");
        return siteUser;
    }

    private ChangePassword getChangePassword() {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setOldUsername("username");
        changePassword.setOldPassword("password");
        changePassword.setNewPassword("newPassword");
        return changePassword;
    }

}
