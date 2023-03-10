package org.example.service;

import org.example.dao.UserDaoImpl;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final UserDaoImpl userDaoMock = mock(UserDaoImpl.class);
    private UserService out;
    private static User userIvan;
    private static User userAlex;
    private final String USER_IVAN = "Ivan";
    private final String USER_ALEX = "Alex";

    @BeforeEach
    void createNewUser() {
        userIvan = new User(USER_IVAN);
        userAlex = new User(USER_ALEX);
    }

    @BeforeEach
    public void initOut() {
        out = new UserService(userDaoMock);
    }

    @Test
    void shouldFindUserBy() {
        when(userDaoMock.getUserByName(USER_IVAN)).thenReturn(userIvan);
        assertTrue(out.checkUserExist(userIvan));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        when(userDaoMock.getUserByName(USER_ALEX)).thenReturn(null);
        assertFalse(out.checkUserExist(userAlex));
    }

}