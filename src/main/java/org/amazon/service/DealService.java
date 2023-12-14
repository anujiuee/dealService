package org.amazon.service;

import org.amazon.dao.DealDao;
import org.amazon.dao.UserDealMapDao;
import org.amazon.exception.AllDealItemSoldException;
import org.amazon.exception.DealAlreadyExpireException;
import org.amazon.exception.DealAlreadyUsedException;
import org.amazon.exception.DealNotFoundException;
import org.amazon.model.Deal;
import org.amazon.model.UserDealMap;

import java.util.Date;

public interface DealService {

    public Deal getDeal(long dealId) throws DealNotFoundException;

    public Deal createDeal(Long productId, int itemCount, Date startTime, Date endTime, long price);

    public Deal updateDeal(long dealId, Date endTime) throws DealNotFoundException, DealAlreadyExpireException ;

    public Deal updateDeal(long dealId, int itemCount) throws DealNotFoundException, DealAlreadyExpireException, AllDealItemSoldException ;
    public UserDealMap ClaimDeal(Long userId, Long dealId) throws DealAlreadyUsedException, DealNotFoundException, DealAlreadyExpireException, AllDealItemSoldException;
}
