package org.amazon.service.impl;

import org.amazon.dao.UserDao;
import org.amazon.exception.UserNotExistException;
import org.amazon.model.User;
import org.amazon.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(long userId) throws UserNotExistException {
       return userDao.getUser(userId);
    }

    public User createUser(String email,String phoneNum){
        return userDao.createUser(email,phoneNum);
    }
}
