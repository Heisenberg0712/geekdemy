package com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons;

import com.example.geektrust.constant.Programmes;
import com.example.geektrust.utility.coupons.abstractCoupon.Coupon;

import java.util.List;

public class B4G1 extends Coupon {

    @Override
    public String getCouponName() {
        return "B4G1";
    }

    @Override
    public boolean checkIfApplicable(List<Programmes> programmesList,double total_cost) {
        int qty = 0;
        for (Programmes programme : programmesList) {
            qty+=programme.getQuantity();
        }
        return qty>=4;
    }

    @Override
    public double applyCoupon(List<Programmes> programmesList, boolean pro, double total_cost) {
        double lowestPricedProgrammePrice=Integer.MAX_VALUE;
        Programmes lowestPricedProgramme = null;
        for(int i=0;i<programmesList.size();i++){
            if(lowestPricedProgrammePrice>programmesList.get(i).getCost()){
                lowestPricedProgramme = programmesList.get(i);
                lowestPricedProgrammePrice = programmesList.get(i).getCost();
            }
        }
        return (pro) ? (lowestPricedProgramme.getCost() - lowestPricedProgramme.getCost()*lowestPricedProgramme.getProDiscount())
                    : lowestPricedProgramme.getCost();
    }
}
