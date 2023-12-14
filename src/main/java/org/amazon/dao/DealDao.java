package org.amazon.dao;

import org.amazon.exception.AllDealItemSoldException;
import org.amazon.exception.DealAlreadyExpireException;
import org.amazon.exception.DealNotFoundException;
import org.amazon.model.Deal;

import java.util.Date;
import java.util.HashMap;

public class DealDao {

    HashMap<Long, Deal> dealMap = new HashMap<>();

    public Deal getDeal(long dealId) throws DealNotFoundException {
        if(dealMap.get(dealId)==null) throw new DealNotFoundException("wrong deal id, this deal not exist in our system");
        return dealMap.get(dealId);
    }

    public Deal createDeal(Long productId, int itemCount, Date startTime,Date endTime, long price){
        Deal deal =  new Deal(startTime,endTime,itemCount,productId,price);
        dealMap.put(deal.getId(),deal);
        return deal;
    }

    public Deal updateDeal(long dealId, Date endTime) throws DealNotFoundException, DealAlreadyExpireException {

        if(dealMap.get(dealId)==null) throw new DealNotFoundException("wrong deal id, this deal not exist in our system");

        Deal deal = dealMap.get(dealId);
        if(new Date().after(deal.getEndTime())){
            throw new DealAlreadyExpireException("deal end time is alreday finish");
        }

        deal.setEndTime(endTime);
        return deal;
    }

    public Deal updateDeal(long dealId, int itemCount) throws DealNotFoundException, DealAlreadyExpireException, AllDealItemSoldException {

        if(dealMap.get(dealId)==null) throw new DealNotFoundException("wrong deal id, this deal not exist in our system");

        Deal deal = dealMap.get(dealId);
      /*  if(new Date().after(deal.getEndTime())){
            throw new DealAlreadyExpireException("deal end time is alreday finish");
        }
        */


        if(deal.getItemCount()<0) throw new AllDealItemSoldException("all stock item sold");

        deal.setItemCount(itemCount);
        return deal;
    }


}
