package org.amazon.dao;

import org.amazon.exception.UserNotExistException;
import org.amazon.model.User;
import org.amazon.model.UserDealMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class UserDealMapDao {

    //userId, dealId Mapping
    HashMap<Long, List<Long>> userDealMap = new HashMap<>();

    public List<Long> getUserDeal(long userId)  {
        return userDealMap.get(userId);
    }


    private Lock lock = new ReentrantLock();

    public UserDealMap createUserDealMap(Long userId,Long dealId){

        UserDealMap userDealMapping =  new UserDealMap(userId,dealId);
        if(!userDealMap.containsKey(userId)){
            userDealMap.put(userId,new ArrayList<>());
        }
        userDealMap.get(userId).add(dealId);
        return userDealMapping;

    }

    public boolean checkIfDealAlreadyUsed(Long userId,Long dealId){

        if(!userDealMap.containsKey(userId)){
            return false;
        }

        List<Long> dealIds = userDealMap.get(userId).stream().filter(x-> x.equals(dealId)).collect(Collectors.toList());
        if(dealIds.isEmpty()) return false;

        return true;

    }


}
