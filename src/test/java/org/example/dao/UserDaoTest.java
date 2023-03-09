package org.example.dao;

import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserDaoTest {
    private static User user;
    private static final UserDaoImpl userDaoImpl = new UserDaoImpl();

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
        assertEquals(user, userDaoImpl.getUserByName(USER_IVAN));
    }

    @Test
    void shouldReturnNullIfUserNotExist() {
        assertNull(userDaoImpl.getUserByName(USER_ALEX));
    }


    @Test
    void findAllUsers() {
        assertEquals(userDaoImpl.findAllUsers(), users);
    }
}