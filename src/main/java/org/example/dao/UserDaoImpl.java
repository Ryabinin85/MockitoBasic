package org.example.dao;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {

    private final List<User> userList = new ArrayList<>();

    public UserDaoImpl() {
        userList.add(new User("Ivan"));
        userList.add(new User("Igor"));
        userList.add(new User("Petya"));
    }


    public User getUserByName(String name) {
        return userList.stream()
                .filter(o -> o.getName().equals(name))
                .findFirst()
                .orElse(null);
    }


    public List<User> findAllUsers() {
        return userList;
    }
}
