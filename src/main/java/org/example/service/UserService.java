package org.example.service;

import org.example.dao.UserDaoImpl;
import org.example.model.User;

public class UserService {

    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        User userByName = userDao.getUserByName(user.getName());
        return userByName != null;
    }
}
