package org.amazon.service;

import org.amazon.exception.UserNotExistException;
import org.amazon.model.User;

public interface UserService {

    public User getUser(long userId) throws UserNotExistException;

    public User createUser(String email,String phoneNum);
}
