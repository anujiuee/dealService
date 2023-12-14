package org.amazon.service.impl;

import org.amazon.dao.DealDao;
import org.amazon.dao.UserDealMapDao;
import org.amazon.exception.AllDealItemSoldException;
import org.amazon.exception.DealAlreadyExpireException;
import org.amazon.exception.DealAlreadyUsedException;
import org.amazon.exception.DealNotFoundException;
import org.amazon.model.Deal;
import org.amazon.model.UserDealMap;
import org.amazon.service.DealService;

import java.util.Date;

public class DealServiceImpl implements DealService {

    private final DealDao dealDao;

    private final UserDealMapDao userDealMapDao;

    public DealServiceImpl(DealDao dealDao, UserDealMapDao userDealMapDao) {
        this.dealDao = dealDao;
        this.userDealMapDao = userDealMapDao;
    }

    public Deal getDeal(long dealId) throws DealNotFoundException {
        return dealDao.getDeal(dealId);
    }

    public Deal createDeal(Long productId, int itemCount, Date startTime, Date endTime, long price){
       return dealDao.createDeal(productId, itemCount, startTime, endTime,price);
    }

    public Deal updateDeal(long dealId, Date endTime) throws DealNotFoundException, DealAlreadyExpireException {
        return dealDao.updateDeal(dealId, endTime);
    }

    public Deal updateDeal(long dealId, int itemCount) throws DealNotFoundException, DealAlreadyExpireException, AllDealItemSoldException {
        return dealDao.updateDeal(dealId, itemCount);
    }

    public UserDealMap ClaimDeal(Long userId, Long dealId) throws DealAlreadyUsedException, DealNotFoundException, DealAlreadyExpireException, AllDealItemSoldException {
        Deal deal = this.getDeal(dealId);
        if(deal.getItemCount()<=0) throw new DealAlreadyUsedException("");
        if(userDealMapDao.checkIfDealAlreadyUsed(userId, dealId)) throw new DealAlreadyUsedException("deal is alreday used by user");
        dealDao.updateDeal(dealId,deal.getItemCount()-1);
        return userDealMapDao.createUserDealMap(userId,dealId);
    }

}
