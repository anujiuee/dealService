package org.amazon.dao;

import org.amazon.exception.UserNotExistException;
import org.amazon.model.User;

import java.util.HashMap;

public class UserDao {

    HashMap<Long, User> userMap = new HashMap<>();

    public User getUser(long userId) throws UserNotExistException {
        if(userMap.get(userId)==null) throw new UserNotExistException("user not exist in our system");
        return userMap.get(userId);
    }

    public User createUser(String email,String phoneNum){
        User user =  new User(email,phoneNum);
        userMap.put(user.getId(),user);
        return user;
    }


}
