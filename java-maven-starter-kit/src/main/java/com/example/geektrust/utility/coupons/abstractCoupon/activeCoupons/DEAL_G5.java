package com.example.geektrust.utility.coupons.abstractCoupon.activeCoupons;

import com.example.geektrust.constant.Programmes;
import com.example.geektrust.utility.coupons.abstractCoupon.Coupon;

import java.util.List;

public class DEAL_G5 extends Coupon {
    @Override
    public double applyCoupon(List<Programmes> programmesList, boolean pro, double total_cost) {
        return (total_cost*0.05);
    }

    @Override
    public String getCouponName() {
        return "DEAL_G5";
    }

    @Override
    public boolean checkIfApplicable(List<Programmes> programmesList, double total_cost) {
        int qty = 0;
        for (Programmes programme : programmesList) {
            qty+=programme.getQuantity();
        }
        return (qty>=2 && qty<4);
    }

}
