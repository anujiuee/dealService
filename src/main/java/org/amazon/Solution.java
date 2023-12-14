package org.amazon;

import org.amazon.model.Deal;
import org.amazon.model.User;
import org.amazon.model.UserDealMap;
import org.amazon.service.DealService;
import org.amazon.util.DealObjGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {

        try {

            System.out.println("Hello world!");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");


            DealService dealService = DealObjGenerator.generateDealObj();

            Deal deal = dealService.createDeal(1l, 3, formatter.parse("28-01-2022 10:15:55 AM"),
                    formatter.parse("22-01-2015 10:15:55 PM"),10l);
            System.out.println(deal);

            User user = new User("anuj@gmail.com","6699669777");

            System.out.println(user);

            Deal deal1 = dealService.updateDeal(deal.getId(),1);

            System.out.println(deal1);

            UserDealMap userDealMap = dealService.ClaimDeal(user.getId(), deal1.getId());

            UserDealMap userDealMap1 = dealService.ClaimDeal(2l, deal1.getId());

            System.out.println(userDealMap);

            System.out.println(dealService.getDeal(deal.getId()));


        } catch (Exception ex){
            System.out.println(ex);
        }



    }
}