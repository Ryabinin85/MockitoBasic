package org.example.dao;

import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {
    private static User user;
    private static final UserDaoImpl out = mock(UserDaoImpl.class);

    private final String USER_IVAN = "Ivan";
    private final String USER_IGOR = "Igor";
    private final String USER_PETYA = "Petya";
    private final String USER_ALEX = "Alex";
    private final List<User> users = List.of(new User(USER_IVAN), new User(USER_IGOR), new User(USER_PETYA));

    @BeforeEach
    void createNewUser() {
        user = new User(USER_IVAN);
    }

    @Test
    void shouldFindUserByNameIfExist() {
        when(out.getUserByName(USER_IVAN)).thenReturn(user);
        assertEquals(user, out.getUserByName(USER_IVAN));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        when(out.getUserByName(USER_ALEX)).thenReturn(null);
        assertNull(out.getUserByName(USER_ALEX));
    }


    @Test
    void findAllUsers() {
        when(out.findAllUsers()).thenReturn(users);
        assertEquals(out.findAllUsers(), users);
    }
}