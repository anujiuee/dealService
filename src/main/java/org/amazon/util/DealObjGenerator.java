package org.amazon.util;

import org.amazon.dao.DealDao;
import org.amazon.dao.UserDao;
import org.amazon.dao.UserDealMapDao;
import org.amazon.model.User;
import org.amazon.service.DealService;
import org.amazon.service.UserService;
import org.amazon.service.impl.DealServiceImpl;
import org.amazon.service.impl.UserServiceImpl;

public class DealObjGenerator {

    private static DealService dealService;

    private static UserService userService;

    public static DealService generateDealObj(){
        dealService =  new DealServiceImpl(new DealDao(),new UserDealMapDao());
        return dealService;
    }

    public static UserService generateUserObj(){
        userService =  new UserServiceImpl(new UserDao());
        return userService;
    }

}
